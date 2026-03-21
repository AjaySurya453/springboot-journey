# ☕ Spring Boot Journey

> Documenting my daily Spring Boot learning —
> from zero to job-ready in 6 months.

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-blue)
![Status](https://img.shields.io/badge/Status-Active-brightgreen)
![Days](https://img.shields.io/badge/Day-6%20of%20100-purple)

---

## 🎯 Goal
Land an entry-level Java Backend Developer role by
building real projects and learning in public daily.

---

## 📅 Daily Progress

| Day | Topic | Key Concepts Learned |
|-----|-------|---------------------|
| Day 1 | Spring Boot Setup | @SpringBootApplication, @GetMapping, Embedded Tomcat |
| Day 2 | CRUD REST API | @RestController, @PathVariable, @RequestBody, HTTP Methods |
| Day 3 | Spring Data JPA + PostgreSQL | @Entity, @Repository, JpaRepository, int vs Integer fix |
| Day 4 | Service Layer | 3-Tier Architecture, @Service, @Autowired, Separation of Concerns |
| Day 5 | Exception Handling + Validation | @ControllerAdvice, Custom Exceptions, @Valid, Bean Validation |
| Day 6 | Spring Security + JWT | JWT Auth, BCrypt, SecurityFilterChain, JwtFilter |

*(Updated daily)*

---

## 🏗️ Project Architecture
```
Request → Controller → Service → Repository → PostgreSQL
               ↑
          JwtFilter (validates token on every request)
               ↑
        SecurityFilterChain
```

---

## 📁 Current File Structure
```
src/main/java/com/tutorial/day/
├── Application.java                 ← App entry point
├── Student.java                     ← Entity + JPA model
├── StudentController.java           ← REST endpoints
├── StudentService.java              ← Business logic
├── StudentRepository.java           ← DB operations
├── StudentNotFoundException.java    ← Custom exception
├── GlobalExceptionHandler.java      ← @ControllerAdvice
├── JwtUtil.java                     ← Token generate/validate
├── JwtFilter.java                   ← Token filter per request
├── SecurityConfig.java              ← Security rules
└── AuthController.java              ← Login endpoint
```

---

## 🚀 API Endpoints

### Auth (Public)
| Method | URL | Description | Auth Required |
|--------|-----|-------------|---------------|
| POST | /auth/login | Login and get JWT token | ❌ No |

### Students (Protected)
| Method | URL | Description | Auth Required |
|--------|-----|-------------|---------------|
| GET | /api/students | Get all students | ✅ Yes |
| GET | /api/students/{id} | Get student by ID | ✅ Yes |
| POST | /api/students | Add new student | ✅ Yes |
| PUT | /api/students/{id} | Update student | ✅ Yes |
| DELETE | /api/students/{id} | Delete student | ✅ Yes |

---

## 🧪 How to Test with Postman

### Step 1 — Login to get token
```
POST localhost:8080/auth/login
Body (raw JSON):
{
  "username": "ajay",
  "password": "password123"
}
```

### Step 2 — Use token in protected requests
```
GET localhost:8080/api/students
Headers:
  Authorization: Bearer <paste_token_here>
```

### Step 3 — Validation test
```
POST localhost:8080/api/students
Body: {"name": "", "email": "notanemail"}
→ Returns validation error messages
```

---

## ⚙️ How to Run Locally
```bash
# 1. Clone the repo
git clone https://github.com/AjaySurya453/springboot-journey.git

# 2. Navigate to project
cd springboot-journey

# 3. Create PostgreSQL database
# Open pgAdmin → Create database named: studentdb

# 4. Update application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/studentdb
spring.datasource.username=postgres
spring.datasource.password=your_password

# 5. Run the app
./mvnw spring-boot:run

# 6. Test it
POST http://localhost:8080/auth/login
```

---

## 🛠️ Tech Stack

| Technology | Version | Purpose |
|------------|---------|---------|
| Java | 17 | Core language |
| Spring Boot | 3.x | Backend framework |
| Spring MVC | 3.x | REST API layer |
| Spring Data JPA | 3.x | ORM / Database layer |
| Spring Security | 3.x | Authentication & Authorization |
| JWT (jjwt) | 0.11.5 | Token-based auth |
| PostgreSQL | 17 | Relational database |
| Maven | 3.x | Build tool |
| Postman | — | API testing |

---

## 📚 What's Coming Next

- [ ] Day 7 — Real User entity + DB-backed authentication
- [ ] Day 8–10 — JPA Relationships (OneToMany, ManyToMany)
- [ ] Day 11–14 — Project 1: Task Manager API (complete)
- [ ] Day 15–18 — Unit Testing (JUnit 5 + Mockito)
- [ ] Day 19–21 — Integration Testing + MockMvc
- [ ] Day 22–24 — Docker containerization
- [ ] Day 25–28 — GitHub Actions CI/CD
- [ ] Day 36+ — AWS deployment
- [ ] Day 43+ — Microservices + Kafka

---

## 🐛 Bugs Fixed Along the Way

| Day | Bug | Fix |
|-----|-----|-----|
| Day 1 | `jakarta.persistence` not found | Added spring-boot-starter-data-jpa dependency |
| Day 3 | `400 Bad Request` on POST | Changed `int` to `Integer` for auto-generated ID |
| Day 3 | Branch named `master` | Renamed to `main` with `git branch -m master main` |

*(Real bugs I hit and fixed — this is how learning works!)*

---

## 📊 LinkedIn Posts

Tracking daily progress publicly on LinkedIn.
Follow along: [linkedin.com/in/ajaysurya453](https://linkedin.com/in/ajaysurya453)

---

## 🔗 Connect With Me

- 💼 LinkedIn: [linkedin.com/in/ajaysurya453](https://linkedin.com/in/ajaysurya453)
- 🐙 GitHub: [github.com/AjaySurya453](https://github.com/AjaySurya453)

---

⭐ If this repo helps your learning journey, give it a star!
