# Sweet Shop Management System – Backend

This project is a backend implementation of a **Sweet Shop Management System** built as part of the **Incubyte Software Craftsman Internship assessment**.

The system provides secure APIs for user authentication, sweet management, inventory handling, and search functionality using **JWT-based authentication**.

---

## 🚀 Tech Stack

- Java 21
- Spring Boot
- Spring Security (JWT Authentication)
- Spring Data JPA
- PostgreSQL
- Maven
- Postman (for API testing)

---

## 🔐 Authentication & Security

- Users can **register** and **login**
- JWT token is generated on successful login
- All protected APIs require a valid JWT token
- Stateless authentication (no sessions)

---

## 📦 Features Implemented

### User Authentication
- Register a new user
- Login and receive JWT token

### Sweet Management (Protected)
- Add a new sweet
- View all sweets
- Search sweets by:
  - Name
  - Category
  - Price range
- Update sweet details
- Delete sweet (Admin only)

### Inventory Management (Protected)
- Purchase sweet (decreases stock)
- Restock sweet (Admin only, increases stock)

Each sweet contains:
- Unique ID
- Name
- Category
- Price
- Quantity in stock

---

## 📌 API Endpoints

### Authentication
| Method | Endpoint | Description |
|------|--------|------------|
| POST | `/auth/register` | Register new user |
| POST | `/auth/login` | Login and get JWT token |

---

### Sweets (Protected)
| Method | Endpoint | Description |
|------|--------|------------|
| POST | `/api/sweets` | Add new sweet |
| GET | `/api/sweets` | Get all sweets |
| GET | `/api/sweets/search` | Search sweets |
| PUT | `/api/sweets/{id}` | Update sweet |
| DELETE | `/api/sweets/{id}` | Delete sweet (Admin) |

---

### Inventory (Protected)
| Method | Endpoint | Description |
|------|--------|------------|
| POST | `/api/sweets/{id}/purchase` | Purchase sweet |
| POST | `/api/sweets/{id}/restock` | Restock sweet (Admin) |

---

## 🧪 Testing the APIs (Postman)

1. Register a user using `/auth/register`
2. Login using `/auth/login`
3. Copy the JWT token from login response
4. Add this header for all protected APIs:
5. Test protected endpoints like `/api/sweets`, `/purchase`, `/restock`, etc.

---

## ⚙️ Running the Application

### Prerequisites
- Java 21 installed
- PostgreSQL running
- Maven installed

### Steps

``` bash
git clone <repository-url>
cd Sweet-Shop-Management-System
mvn clean install
mvn spring-boot:run

---

## ✅ NEXT STEPS (VERY SHORT)

### 1️⃣ Create README file
- In IntelliJ → right click project root
- New → File → `README.md`
- Paste content above

### 2️⃣ Commit README
```bash
git add README.md
git commit -m "Add README with project overview and API documentation"
git push origin main

