# microservices

 A simple microservice architecture for studies purpose only, using: 
 * eureka server for services registries,
 * open feign to the internal communication between clients,
 * api gateway service to handle the requests to the consumer service, 
 * rabbitmq to create the notification service queue and consume the costumer service producer and send the notifications,
 * zipkin keeping trace of everything that is happening,
 * docker to get the zipkin, rabbitmq and postgres images and define its ports
 
