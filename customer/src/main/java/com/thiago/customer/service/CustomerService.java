package com.thiago.customer.service;

import com.thiago.amqp.RabbitMQMessageProducer;
import com.thiago.clients.fraud.FraudCheckResponse;
import com.thiago.clients.fraud.FraudClient;
import com.thiago.clients.notification.NotificationRequest;
import com.thiago.customer.model.Customer;
import com.thiago.customer.model.record.CustomerRegistrationRequest;
import com.thiago.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        repository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse =
                fraudClient.isFrauder(customer.getId());

        if (fraudCheckResponse.isFrauder()) {
            throw new IllegalStateException("fraudster");
        }

        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to microservices...",
                        customer.getFirstName())
        );
        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );

    }

}
