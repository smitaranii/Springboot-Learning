# 🌱 Week 1: Introduction to Spring & Spring Boot

## 1️⃣ Spring Framework Basics

**What is Spring?** 🤔  
- **Spring** is a **Java framework** that makes apps **loosely coupled**.  
- Lets you build apps from **POJOs (Plain Old Java Objects)**.  
- Enterprise features (transactions, security) can be added **without touching POJOs**.  
- Created by **Rod Johnson in 2003**.  

**Key Components 🛠️:**  
- **Core Container** – Manages beans & DI  
- **AOP (Aspect-Oriented Programming)** – Handles logging, transactions  
- **JDBC** – Database access  
- **Web** – Build web apps  
- **Testing** – Write testable code  

## 2️⃣ IoC Container (Inversion of Control) 🔄  

- **IoC container = heart of Spring ❤️**  
- **Creates objects (beans), wires them together, injects dependencies, and manages lifecycle**.  
- Instead of a class creating its own dependencies, **Spring does it for you**.  

## 3️⃣ Spring Beans 🧩  

**What is a Bean?**  
- A **bean = Java object managed by Spring**.  
- Spring **creates, injects dependencies, and manages its lifecycle**.  

**Defining Beans ✏️**  
- **Stereotype Annotations**: `@Component`, `@Service`, `@Repository`, `@Controller`  
- **Configuration Class**: Use `@Configuration` + `@Bean` methods  

**Bean Lifecycle 🔄**  
1. **Bean is created**  
2. **Dependencies are injected**  
3. **Bean is initialized**  
4. **Bean is used**  
5. **Bean is destroyed**  

**Lifecycle Hooks ⏳**  
- `@PostConstruct` – Run method after initialization  
- `@PreDestroy` – Run method before destruction  

**Bean Scopes 🌐**  

| **Scope**     | **Description** |
|---------------|----------------|
| **singleton** | Default. 1 instance per container |
| **prototype** | New instance every request |
| **request**   | 1 bean per HTTP request |
| **websocket** | 1 bean per WebSocket connection |

## 4️⃣ Dependency Injection (DI) 💉  

**What is DI?**  
- **Spring injects dependencies into a class** instead of the class creating them.  
- Example: Alice needs Frosting → **Spring injects it automatically**.  

**Benefits 💡**  
- **Loose Coupling** – Easier to maintain & test  
- **Flexible Configuration** – Swap components easily  
- **Improved Testability** – Mock dependencies easily  

**Ways to Inject Dependencies ⚡**  
- **Constructor Injection** – Pass dependencies in constructor  
- **Field Injection** – Use `@Autowired` on fields  

## 5️⃣ Spring Boot vs Spring Framework 🚀  

**Why Spring Boot?**  
- **Starter dependencies** – ready-to-use libraries  
- **Auto-configuration** – configures app automatically  
- **Embedded servers** – no need to install Tomcat/Jetty  
- **Externalized configuration** – configure via files, env variables, or CLI  
- Built-in **metrics & health checks** ✅  

## 6️⃣ Auto-Configuration & Internal Flow of Spring Boot 🔧  

**Auto-Configuration 🪄**  
- Automatically configures app based on **dependencies & settings**  
- Saves **manual configuration**  

**How It Works 🔍**  
- **Classpath Scanning** – finds libraries/classes  
- **Configuration Classes** – creates beans if conditions met  
- **Conditional Checks** – examples:  
  - `@ConditionalOnBean(DataSource.class)` ✅ only if DataSource exists  
  - `@ConditionalOnClass(DataSource.class)` ✅ only if class exists  
  - `@ConditionalOnProperty("my.property")` ✅ only if property exists  

**Internal Flow 🔄**  
1. `@SpringBootApplication` – **entry point**  
2. **Application Context Creation** – scans & initializes beans  
3. **Auto-Configuration** – creates beans based on conditions  
4. **External Configuration** – loads properties from files/env/CLI  
5. **Embedded Web Server** – starts server for web apps  
6. **Application Startup** – runs `@PostConstruct` methods  
7. **Application Ready** – app is fully ready 🚀  

## 7️⃣ Maven Basics 🍴  

- **Maven = Build & dependency management tool for Java**  
- Uses **pom.xml** to define project structure & dependencies  
- Automates **build, test, packaging, deployment**  

**Common Maven Commands 🛠️**  

| **Command**                  | **Description** |
|-------------------------------|----------------|
| `mvn compile`                 | Compile source code |
| `mvn clean`                   | Delete old build files |
| `mvn test`                    | Run tests |
| `mvn package`                 | Create JAR/WAR |
| `mvn install`                 | Store artifact in local repo |
| `mvn deploy`                  | Copy artifact to remote repo |
| `mvn spring-boot:run`         | Run app without packaging |
| `mvn spring-boot:build-image` | Build Docker image |

## 8️⃣ List of Spring Annotations Learned 🏷️  

| **Annotation**                  | **What It Does** |
|---------------------------------|----------------|
| `@Component`                    | Make class a Spring bean |
| `@Service`                      | Same as `@Component`, for service layer |
| `@Repository`                   | Same as `@Component`, for DAO layer |
| `@Controller`                   | Marks class as web controller |
| `@RestController`               | API controller (returns JSON) |
| `@Autowired`                     | Inject dependency |
| `@Qualifier`                     | Specify which bean to inject |
| `@Primary`                       | Mark default bean |
| `@SpringBootApplication`         | Main Spring Boot annotation |
| `@PostConstruct`                 | Run method after bean init |
| `@PreDestroy`                    | Run method before bean destruction |
| `@Test`                           | Mark method as a JUnit test case |
| `@Override`                       | Ensure method overrides parent/interface method |
| `@Configuration`                  | Class contains bean definitions |
| `@Bean`                           | Method creates a Spring bean |
| `@Scope("prototype")`             | New instance every time (default singleton) |
| `@ConditionalOnProperty`          | Bean created only if property exists |
