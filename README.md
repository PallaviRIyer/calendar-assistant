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
![Screenshot 2024-04-29 173656](https://github.com/PallaviRIyer/calendar-assistant/assets/79352525/9c57beca-910d-4cb3-8775-b935e0c2453e)

- **GET /api/calendar/freeslots**: Find free slots for a meeting.![Screenshot 2024-04-29 180026](https://github.com/PallaviRIyer/calendar-assistant/assets/79352525/69cf4a42-2f24-4934-acf9-acce1ef5f4f7)

- **POST /api/calendar/conflicts**: Check for meeting conflicts![Screenshot 2024-04-29 180705](https://github.com/PallaviRIyer/calendar-assistant/assets/79352525/de6845f1-0332-4cfc-824b-93661903b8df)
.
- 
- **POST /api/calendar/book**: Book a meeting.
![Screenshot 2024-04-29 180219](https://github.com/PallaviRIyer/calendar-assistant/assets/79352525/95de4252-9998-454e-a8d0-723bee19051b)

