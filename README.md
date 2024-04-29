# Calendar Assistant

## Overview

Calendar Assistant is a RESTful API application designed to assist calendar owners in managing their schedules and helping other users book meetings with them. It also provides functionality to find free slots for meetings and check for meeting conflicts among participants. This application is built with Java and Spring Boot, ensuring high performance and scalability.

## Features

- **Book Meeting with Calendar Owner**: Allows users to book meetings with the calendar owner.
- **Find Free Slots**: Given the calendar of two employees, it finds out the free slots where a meeting of a fixed duration (e.g., half an hour) can be scheduled.
- **Check for Conflicts**: Given a meeting request, it finds out if any participants have meeting conflicts.

## Technical Stack

- **Java**: The application is written in Java 17.
- **Spring Boot**: Utilizes Spring Boot for building the RESTful API.
- **Spring Data JPA**: For data persistence and database interactions.
- **H2 Database**: An in-memory database used for development and testing.

## Dependencies

The project uses the following dependencies:

- `spring-boot-starter-data-jpa` for Spring Data JPA support.
- `spring-boot-starter-web` for creating web applications and RESTful services.
- `spring-boot-devtools` for automatic restart and live reload during development.
- `h2` for an in-memory database.
- `spring-boot-starter-test` for testing support.

## Getting Started

### Prerequisites

- Java 17
- Maven

### Testing with Postman

The application is testable using Postman. Import the provided Postman collection to test the endpoints.

## Endpoints

- **POST /api/calendar/create**: Book a meeting with the calendar owner.
- **GET /api/calendar/freeslots**: Find free slots for a meeting.
- **POST /api/calendar/conflicts**: Check for meeting conflicts.
- **POST /api/calendar/book**: Book a meeting.

