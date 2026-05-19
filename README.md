# Learning Microservices

A hands-on microservices project built with **Spring Boot**, **Spring Cloud**, and **Netflix Eureka** — demonstrating service discovery, API gateway routing, inter-service communication via Feign, and a scalable architecture ready for extension.

---

##  Architecture Overview

```
Client
  │
  ▼
API Gateway (port 8083)          ← Single entry point for all services
  │
  ├──► Quiz Service (port 8081)  ← Manages quizzes, aggregates questions
  │         │
  │         └──► Question Service (port 9092)  ← Manages questions via Feign
  │
  └──► Question Service (port 9092)
  
Eureka Server (port 8761)        ← Service registry & discovery
```

---

##  Services

| Service | Port | Description |
|---|---|---|
| **Eureka Server** | 8761 | Service registry — all services register and discover each other here |
| **API Gateway** | 8083 | Reactive gateway (Spring Cloud Gateway + WebFlux) — routes all client requests |
| **Quiz Service** | 8081 | Creates and manages quizzes, fetches questions via Feign client |
| **Question Service** | 9092 | CRUD operations for questions, serves questions by quiz ID |
| **Result Service** | _TBD_ | Evaluates quiz submissions and calculates scores _(coming soon)_ |
| **Report Service** | _TBD_ | Generates performance reports and analytics _(coming soon)_ |

---

##  Tech Stack

- **Java 21**
- **Spring Boot 3.5.6**
- **Spring Cloud 2025.0.0**
- **Spring Cloud Netflix Eureka** — Service discovery
- **Spring Cloud Gateway (WebFlux)** — API Gateway
- **Spring Cloud OpenFeign** — Declarative HTTP client for inter-service calls
- **Spring Cloud LoadBalancer** — Client-side load balancing
- **Spring Data JPA + Hibernate** — ORM and persistence
- **MySQL** — Relational database
- **Lombok** — Boilerplate reduction

---

##  Getting Started

### Prerequisites
- Java 21+
- Maven 3.8+
- MySQL 8.0+

### Database Setup

Create the required databases in MySQL:

```sql
CREATE DATABASE Quiz_db;
CREATE DATABASE question_db;
```

### Running the Services

Start services **in this order**:

```bash
# 1. Eureka Server
cd EurekaServer && mvn spring-boot:run

# 2. Question Service
cd QuestionService && mvn spring-boot:run

# 3. Quiz Service
cd QuizService && mvn spring-boot:run

# 4. API Gateway
cd ApiGateway && mvn spring-boot:run
```

### Verify Registration

Open Eureka Dashboard: [http://localhost:8761]

All services should appear as **UP**.

---

##  API Endpoints

All requests go through the **API Gateway at port 8083**.

### Question Service
| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/question/allQuestions` | Get all questions |
| `GET` | `/question/quiz/{quizId}` | Get questions for a quiz |
| `POST` | `/question/add` | Add a new question |

### Quiz Service
| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/quiz` | Get all quizzes |
| `GET` | `/quiz/{id}` | Get quiz by ID |
| `POST` | `/quiz/create` | Create a new quiz |
| `POST` | `/quiz/submit/{id}` | Submit quiz answers |

---

##  Roadmap

- [x] Eureka Service Registry
- [x] API Gateway with route configuration
- [x] Question Service with MySQL persistence
- [x] Quiz Service with Feign inter-service communication
- [ ] Result Service — score evaluation and submission tracking
- [ ] Report Service — performance analytics and reporting
- [ ] JWT Authentication via Gateway filter
- [ ] Docker Compose setup
- [ ] Kubernetes deployment manifests

---

##  Project Structure

```
learning-microservices/
├── EurekaServer/
├── ApiGateway/
├── QuizService/
├── QuestionService/
├── ResultService/        (coming soon)
└── ReportService/        (coming soon)
```

---

