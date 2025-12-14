# 🏦 PureStack Fintech Core: Spring Boot, ACID & Concurrency Protocol

**PureStack.es - Engineering Validation Protocol.**
> *"In Fintech, 99.9% reliability is a failure. We audit for ACID compliance and Concurrency safety."*

---

### 📋 Context & Mission
Welcome to the PureStack Technical Validation Protocol for Backend Engineering.
In the financial sector, a transaction must either complete fully or not happen at all. Partial updates are unacceptable.

**The Mission:** You are building the core engine of a **Money Transfer Service**.
Your goal is to implement a robust, thread-safe API that handles transfers between accounts without losing a single cent, even under high concurrency.

### 🚦 Certification Levels (Choose your Difficulty)
Your seniority is defined by how you handle transactions, concurrency, and architecture. State your target level in your Pull Request.

#### 🥉 Level 3: Essential / Mid-Level
* **Focus:** ACID Compliance & Basic Logic.
* **Requirement:** Implement a functional `transfer` endpoint.
* **Tasks:**
    1.  **Endpoint:** `POST /transfer` (Input: sourceId, targetId, amount).
    2.  **ACID Logic:** Use `@Transactional`. If the credit to the target fails, the debit from the source **must** rollback automatically.
    3.  **Validation:** Prevent transfers if balance is insufficient or amounts are negative.
* **Deliverable:** A working API where money never disappears into the void.

#### 🥈 Level 2: Pro / Senior
* **Focus:** Clean Architecture, DTOs & Error Handling.
* **Requirement:** Everything in Level 3 + **Decoupling & Resilience**.
* **Extra Tasks:**
    1.  **No Leaky Abstractions:** Do NOT expose your Database Entities (`Account`) in the Controller. Use **DTOs** (Data Transfer Objects) for requests and responses.
    2.  **Global Exception Handling:** Implement a `@ControllerAdvice` to handle exceptions (e.g., `InsufficientFundsException`) and return clean JSON error responses (400/404) instead of stack traces.
    3.  **Unit Testing:** Extend the test suite using **Mockito** to verify business logic in isolation from the database.
* **Deliverable:** Production-ready code that is maintainable and testable.

#### 🥇 Level 1: Elite / Architect
* **Focus:** Concurrency, Locking Strategies & Idempotency.
* **Requirement:** Everything above + **Race Condition Handling**.
* **Extra Tasks:**
    1.  **Optimistic Locking:** Handle **Race Conditions**. What happens if two requests try to withdraw money from the same account simultaneously? Implement `@Version` (Optimistic Locking) to prevent "Lost Updates".
    2.  **Idempotency:** Implement a mechanism to ensure that if the same API request (same `idempotency-key` header) is sent twice (e.g., due to network retry), the transfer happens only once.
    3.  **Integration Tests:** Write a concurrency test (using `ExecutorService` or similar) that simulates 10 threads transferring money at the same time to prove your locking works.
* **Deliverable:** A bulletproof financial system robust against high-load scenarios.

---

### 🛠️ Tech Stack Requirements
* **Language:** Java 17+ or 21 (LTS).
* **Framework:** Spring Boot 3.x.
* **Database:** H2 (In-Memory for portability).
* **Persistence:** Spring Data JPA / Hibernate.
* **Build Tool:** Maven.

---

### 🚀 Execution Instructions

1.  **Fork** this repository.
2.  Inspect `src/main/resources/data.sql` (it pre-loads 2 test accounts).
3.  Implement the logic in `TransferService.java` (and create DTOs/Exceptions as needed).
4.  Run tests: `mvn test`.
5.  Submit via **Pull Request** stating your target Level.

### 🧪 Evaluation Criteria (PureStack Audit)

| Criteria | Weight | Audit Focus |
| :--- | :--- | :--- |
| **Transactional Integrity** | 35% | Correct use of `@Transactional`. Rollback behavior. |
| **Concurrency Safety** | 30% | Handling of race conditions (Level 1). Optimistic Locking. |
| **Architecture** | 20% | Usage of DTOs, Service Layer, and Dependency Injection. |
| **Code Quality** | 15% | Naming conventions, Exception handling, and Test coverage. |

---

### 🚨 Project Structure (Standard)
To ensure our **Automated Auditor** works, keep the core package structure:

```text
/
├── .github/workflows/   # PureStack Audit System (DO NOT TOUCH)
├── src/
│   ├── main/java/com/purestack/fintech/
│   │   ├── model/       # JPA Entities (Account)
│   │   ├── repository/  # Spring Data Repositories
│   │   ├── service/     # Business Logic (TransferService)
│   │   ├── controller/  # API Layer
│   │   ├── dto/         # Data Transfer Objects (Level 2+)
│   │   └── FintechApplication.java
│   └── test/            # JUnit Tests
├── pom.xml              # Maven Dependencies
└── README.md
