# 🏦 PureStack Java Engineering Challenge: The Fintech Core

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
