# 🌱 **Week 2 – Spring Boot Web**

This document covers the fundamentals of **Spring Boot Web**, **REST APIs**, **MVC architecture**, **controllers**, **persistence layer**, **service layer**, **validation**, and **exception handling**.

---

## ⭐ **2.1 Spring Boot Web**

### 🌐 **What is a REST API?**

A REST API allows applications to communicate over the internet using:

- URLs (like `/users`)
- HTTP Methods (GET, POST, PUT…)
- JSON data

Think of REST API like a **restaurant waiter** 🍽️:

- You request food → API receives request  
- Kitchen prepares food → Server processes data  
- Waiter brings food → API sends response  

---

### 🚀 **Common REST API Endpoints**

| Method     | Purpose                 | Example     |
| ---------- | ----------------------- | ----------- |
| **GET**    | Fetch data              | `/users`    |
| **GET**    | Fetch by ID             | `/users/10` |
| **POST**   | Create new data         | `/users`    |
| **PUT**    | Update entire record    | `/users/10` |
| **PATCH**  | Update part of a record | `/users/10` |
| **DELETE** | Remove a record         | `/users/10` |

---

## 🏗️ **Spring Boot MVC Architecture**

MVC helps structure code into clear layers:

- **Controller** → Handles API requests  
- **Service** → Contains business logic  
- **Repository** → Talks to the database  
- **Entity** → Represents database tables  
- **DTO** → Clean objects for API input/output  

### ⭐ **Why MVC?**

- Separation of concerns  
- Easy to test  
- Reusable components  
- Scalable and maintainable  

---

## 🎨 **2.2 Presentation Layer**

This is where the application receives requests and sends responses.

---

## 🎮 **Controllers**

Controllers handle incoming requests and send responses.  
Spring provides two main annotations:

### 🔵 **@RestController**
- Returns JSON data directly  
- Used for REST APIs  
- Equivalent to: **@Controller + @ResponseBody**

### 🟢 **@Controller**
- Returns HTML pages  
- Used with Thymeleaf-type UIs  

| Annotation       | Purpose        |
| ---------------- | -------------- |
| `@GetMapping`    | Read data      |
| `@PostMapping`   | Create data    |
| `@PutMapping`    | Update data    |
| `@DeleteMapping` | Delete data    |
| `@PatchMapping`  | Partial update |

**Example:**
```java
@GetMapping("/users")
public List<User> getUsers() { }
```

---

## 🛣️ **Dynamic URLs**

### 🟦 **Path Variable**

Part of the URL → `/employees/10`

```java
@GetMapping("/employees/{id}")
public Employee getById(@PathVariable int id) { }
```

### 🟩 **Request Param**

After `?` in URL → `/employees?id=10`

```java
@GetMapping("/employees")
public Employee getEmp(@RequestParam int id) { }
```

---

## 📦 **@RequestBody**

Used when client sends JSON in the request body.

**Example JSON:**
```json
{
  "name": "Rani",
  "age": 30
}
```

**Java code:**
```java
@PostMapping("/users")
public void create(@RequestBody User user) { }
```

---

## 🗄️ **2.3 Persistence Layer & JPA**

### 🧩 **What is JPA?**

JPA is a specification that helps Java applications:

- communicate with databases  
- without writing SQL manually  
- using ORM (Object Relational Mapping)  

Java class → Database table  
Java field → Table column  

---

### 🧪 **H2 Database**

A lightweight, in-memory database used for:

- learning  
- testing  
- development  

Spring automatically configures it with the dependency.

---

### 🏷️ **@Entity Annotation**

Marks a Java class as a database table.

**Example:**
```java
@Entity
public class User {
   @Id
   private int id;
   private String name;
}
```

**Key Points:**
- Class becomes table  
- Fields become columns  
- Must have @Id  
- Managed by JPA  

---

### 📚 **JpaRepository**

Provides ready-made CRUD functions:

- save()  
- findAll()  
- findById()  
- deleteById()  

**Example:**
```java
public interface UserRepo extends JpaRepository<User, Integer> {}
```

---

## ⚙️ **2.4 Service Layer**

The service layer contains business logic.

### Why do we need it?

✔ Keeps controllers clean  
✔ Reusable logic  
✔ Better testing  
✔ Handles complex workflows  

**Example:**
```java
public User saveUser(UserDto dto) {
   User user = convert(dto);
   return repo.save(user);
}
```

---

## 📝 **2.5 PUT, PATCH & DELETE**

### 🟢 **PUT**
Updates a full record.

### 🟡 **PATCH**
Updates only selected fields.

### 🔴 **DELETE**
Removes record by ID.

**Example:**
```java
@DeleteMapping("/users/{id}")
public void delete(@PathVariable int id) { }
```

---

## ⭐ **2.6 Input Validation (Very Beginner-Friendly)**

Validation ensures incoming data is correct.  
Applied in DTO classes.

### 📝 Common Validation Annotations

| Annotation      | Meaning                   |
|----------------|---------------------------|
| @NotNull       | Cannot be null (empty allowed) |
| @NotEmpty      | Cannot be null or empty   |
| @NotBlank      | Cannot be blank           |
| @Size(min,max) | Check length/size         |
| @Email         | Must be valid email       |
| @Pattern       | Must match regex          |
| @Positive      | Must be > 0               |
| @PositiveOrZero| Must be ≥ 0               |
| @Past          | Date must be past         |
| @Future        | Date must be future       |
| @Valid         | Validate nested objects   |

---

### ❗ **Handling Validation Errors**

When validation fails, Spring throws:

`MethodArgumentNotValidException`

You can extract errors and return custom error messages.

---

## ⚠️ **2.7 Exception Handling in Spring Boot**

### Why it’s important?

- Avoid crashes  
- Provide user-friendly messages  
- Debug easier  
- Maintain consistent responses  

### Ways to handle exceptions

1️⃣ **@ExceptionHandler**  
Controller-specific exception handling.

2️⃣ **@RestControllerAdvice**  
Global exception handler.

3️⃣ **Custom Error Response**

Example:
```json
{
  "message": "Something went wrong",
  "timestamp": "2025-01-01"
}
```

---

## 🔄 **2.8 Transforming API Responses**

You can control how all API responses look by using:

- **@ResponseBodyAdvice**
- **@RestControllerAdvice**

### Use cases:

- Add timestamps  
- Add "success" flags  
- Add custom wrappers  

---
