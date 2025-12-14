# 🏦 PureStack Fintech Core: Spring Boot, ACID & Concurrency Protocol.

PureStack.es - Engineering. Validated by Code.

### Context
Welcome to the **PureStack Technical Validation Protocol** for Backend Engineering.
In the Fintech sector, reliability is not optional. A transaction must either complete fully or not happen at all. Partial updates are unacceptable.

**⚠️ The Standard:** We expect **Production-Ready Code**. This means Clean Architecture, ACID Compliance, and Proper Error Handling.

---

### 🎯 The Objective
You are building the core of a **Money Transfer Service**.
Your mission is to implement a RESTful API that handles transfers between accounts.

1.  **The Endpoint:** `POST /transfer`
    * Input: `sourceAccountId`, `targetAccountId`, `amount`.
    * Output: `200 OK` (if successful), `400 Bad Request` (insufficient funds), `500 Internal Error` (system failure).
2.  **The Logic:**
    * Validate balance.
    * Debit source account.
    * Credit target account.
    * **CRITICAL:** The operation must be **Atomic**. If the credit fails, the debit must rollback.
3.  **The Persistence:** Use H2 (In-Memory Database) with JPA/Hibernate.

---

### 🛠️ Tech Stack Requirements
* **Language:** Java 17+ or 21.
* **Framework:** Spring Boot 3.x.
* **Database:** H2 (configured in `application.properties`).
* **Testing:** JUnit 5 + Mockito.

### 🧪 Evaluation Criteria (How we audit you)
We will clone your repo and run `mvn test`. We look for:

* **Green Lights:** Your code must pass the provided test suite.
* **Transactional Integrity:** Usage of `@Transactional`. What happens if an exception is thrown after the debit?
* **Concurrency:** (Bonus) How do you handle two simultaneous requests for the same account? (Optimistic Locking / `version` column).
* **Code Cleanliness:** Clear separation of concerns (Controller vs Service).

### 🚀 Getting Started
1. **Use this template**.
2. Inspect `src/main/resources/data.sql` (it pre-loads 2 accounts).
3. Implement `TransferService.java`.
4. Run tests: `mvn test`.
5. Submit via Pull Request.

---

### 🚨 CRITICAL: Project Structure
To ensure our **Automated Auditor** works, keep this package structure.

```text
/
├── .github/workflows/   # PureStack Audit System
├── src/
│   ├── main/java/com/purestack/fintech/
│   │   ├── model/       # Entities (Account)
│   │   ├── service/     # Business Logic (TransferService)
│   │   ├── controller/  # API Layer
│   │   └── FintechApplication.java
│   └── test/            # JUnit Tests
├── pom.xml              # Maven Dependencies
└── README.md
