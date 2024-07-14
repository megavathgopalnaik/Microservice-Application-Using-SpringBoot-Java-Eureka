#Microservices Application using Java Spring Boot

This repository contains a microservices application built with Java Spring Boot, leveraging Eureka for service discovery, Feign Client, WebClient, and RestTemplate for inter-service communication, and Spring Cloud Gateway for API gateway functionality. The application also utilizes centralized configuration stored in Git.

#Features

* Service Discovery: Eureka server is used for service registration and discovery.

 *Inter-Service Communication:

* Feign Client: Declarative REST client for making HTTP                                requests to other services.

* WebClient: Reactive, non-blocking client to perform requests.

* RestTemplate: Synchronous client for making HTTP requests.

* API Gateway: Spring Cloud Gateway is configured as the gateway for routing requests to microservices.

* Centralized Configuration: Application configuration is managed centrally using Git repositories.

#Modules

* Eureka Server: Centralized service registry for all 
#microservices.

* API Gateway (apigateway-service): Gateway service for routing requests to appropriate microservices.

* Address Service (address-service): Manages address-related operations.

* Employee Service (employee-service): Manages employee-related operations.

*ConfigService (configserver): Manages Central Configuration from GIT Repo.

#Prerequisites
Java 11 or higher
Maven 3.6.x or higher
Git client
IDE (IntelliJ IDEA, Eclipse, etc.)# Microservice-Application-Using-SpringBoot-Java-Eureka
