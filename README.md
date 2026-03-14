# Spring Boot Automation Framework: Enterprise Testing Ecosystem

This repository contains a high-performance test automation framework built on **Spring Boot**. By leveraging the power of the Spring ecosystem, this framework achieves a "Shift-Left" ready architecture with minimal boilerplate code, high modularity, and seamless integration with enterprise Java environments.

## Key Features & Architectural Solutions

### 1. Dependency Injection & Lifecycle Management
* **Spring DI:** Eliminated manual object instantiation. Page Objects and components are managed as Spring Beans, ensuring clean dependency management.
* **WebDriver Management:** Integrated automated WebDriver lifecycle handling, ensuring thread-safe instances for parallel execution.

### 2. Aspect-Oriented Programming (AOP)
* **Smart UI Interactions:** Implemented custom aspects for automatic Window and Frame switching using annotations (e.g., `@Window`).
* **Automated Observability:** Developed AOP-based screenshot capturing and logging that triggers automatically on test failures, keeping the test code clean.

### 3. Data & Environment Management
* **Spring Data JPA:** Used for sophisticated Data-Driven testing, allowing the framework to interact with databases and external data sources as easily as a production app.
* **Spring Profiles:** Seamlessly switch between `local`, `qa`, and `remote-grid` environments via simple configuration profiles.

### 4. Behavior-Driven Development (BDD)
* **Cucumber Integration:** Full BDD support with Gherkin feature files, backed by Spring-managed step definitions for better collaboration and readability.

### 5. Advanced Scalability
* **Parallel Execution:** Native support for multi-threaded runs with clear thread-specific scoping.
* **Localization Testing:** Built-in support for validating multi-language applications using Spring’s resource handling.

## Tech Stack
* **Core:** Java 11+, Spring Boot
* **UI Automation:** Selenium WebDriver
* **BDD:** Cucumber
* **Database:** Spring Data JPA
* **Tools:** AspectJ (AOP), Maven, Lombok

## Configuration
The framework uses `application.properties` and Profiles for environment management:
```properties
# Example: application-qa.properties
app.url=[https://qa-environment.com](https://qa-environment.com)
browser=chrome
grid.url=http://selenium-grid:4444/wd/hub
