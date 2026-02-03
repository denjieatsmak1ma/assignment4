Assignment 4 — SOLID & Advanced OOP
1. Overview

Java application for managing traffic accidents, refactored using SOLID principles and a layered architecture with JDBC and PostgreSQL.

2. SOLID Principles

SRP: Controller, Service, Repository, Model have separate responsibilities.

OCP: New accident types are added via subclasses without modifying existing code.

LSP: Subclasses work correctly through the base class.

ISP: Small, focused interfaces are used.

DIP: Services depend on interfaces, not implementations.

3. Advanced OOP

Generics: Generic CRUD repository.

Lambdas: Sorting accidents by severity.

Reflection: Runtime inspection of classes.

Interfaces: Default and static methods demonstrated.

4. OOP Design

Abstract base class with two subclasses.

Composition between accident and sensor data.

Polymorphism via base class references.

UML diagram included.

5. Database

Two related tables with a foreign key.

Constraints for data integrity.

Sample insert statements provided.

6. Architecture

Controller → Service → Repository → Database.

7. Demonstration

CRUD operations, validation errors, sorting, and reflection output are shown.

8. Reflection

The project demonstrates how SOLID principles improve code structure, readability, and maintainability.

