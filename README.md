# 📚 Book Management Store – Spring Boot Application

A secure and user-friendly **Book Management System** built with **Spring Boot**, featuring **JWT-based authentication**, full **CRUD operations** for books and users, and the ability to **assign books to users**. Designed with modular architecture and clean REST APIs.

---

## 🧩 Features

- 🔐 **JWT Authentication**  
  - Secure user login and signup  
  - Token-based access control for APIs

- 📚 **Book Management**  
  - Add, update, delete, and view books  
  - Assign books to registered users

- 👤 **User Management**  
  - Register new users  
  - Login to receive JWT  
  - View user details and assigned books

- 🧪 **Unit & Integration Testing**  
  - Written using JUnit & Mockito

---

## 🛠️ Tech Stack

- **Spring Boot 3.x**
- **Spring Security + JWT**
- **Spring Data JPA + Hibernate**
- **PostgreSQL** (or H2 for testing)
- **Lombok**
- **JUnit + Mockito**
- **ModelMapper** or **MapStruct**

---

## 🔐 Authentication Flow

1. User signs up (`/api/auth/signup`)
2. User logs in (`/api/auth/login`) → receives JWT
3. JWT is passed in `Authorization: Bearer <token>` for secure endpoints

---

## 📦 Available Endpoints

### Auth:
- `POST /api/auth/signup` – Register new user
- `POST /api/auth/login` – Login and receive JWT

### Books:
- `GET /api/books` – List all books
- `POST /api/books` – Add new book
- `PUT /api/books/{id}` – Update book
- `DELETE /api/books/{id}` – Delete book
- `POST /api/books/assign?userId=1&bookId=2` – Assign a book to a user

### Users:
- `GET /api/users/{id}` – Get user details and assigned books

> 🛡️ All routes (except signup/login) are protected and require a valid JWT token.

---

## 📥 Setup Instructions

1. **Clone the repo**

```bash
git clone https://github.com/your-username/book-management-store.git
cd book-management-store
