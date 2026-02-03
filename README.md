Assignment 4 — SOLID & Advanced OOP
Overview

Java application for managing traffic accidents, refactored using SOLID principles and a layered architecture with JDBC and PostgreSQL.

SOLID Principles

SRP: Controller, Service, Repository, Model have separate responsibilities.

OCP: New accident types are added via subclasses without modifying existing code.

LSP: Subclasses work correctly through the base class.

ISP: Small, focused interfaces are used.

DIP: Services depend on interfaces, not implementations.

Advanced OOP

Generics: Generic CRUD repository.

Lambdas: Sorting accidents by severity.

Reflection: Runtime inspection of classes.

Interfaces: Default and static methods demonstrated.

OOP Design

Abstract base class with two subclasses.

Composition between accident and sensor data.

Polymorphism via base class references.

UML diagram included.

Database

Two related tables with a foreign key.

Constraints for data integrity.

Sample insert statements provided.

Architecture

Controller → Service → Repository → Database.

Demonstration

CRUD operations, validation errors, sorting, and reflection output are shown.

Reflection

The project demonstrates how SOLID principles improve code structure, readability, and maintainability.
