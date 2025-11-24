# 🐾 Pokédex Trainer API
A fun, pop-culture–themed **Spring Boot API** where Trainers collect Pokémon.  
This project demonstrates **JPA relationships**, **searching**, **CRUD operations**, and clean code structure.

---

## 📚 Overview
This API manages two related entities:

- **Trainer** – represents a Pokémon trainer
- **Pokémon** – represents a Pokémon belonging to a specific trainer

Relationship: **One Trainer → Many Pokémon**

The API includes dynamic search endpoints allowing you to filter results using optional query parameters on any field.

---

## 🧱 Technologies Used
- Java 23+
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

---

## 👥 Entities

### 🧑‍🚀 Trainer
| Field | Type | Description |
|-------|------|-------------|
| id | Long | Primary key |
| name | String | Trainer’s name |
| region | String | Pokémon region (Kanto, Johto, etc.) |
| level | int | Skill/experience level |

---

### 🐉 Pokémon
| Field | Type | Description |
|-------|------|-------------|
| id | Long | Primary key |
| name | String | Pokémon name |
| type | String | Fire, Water, Grass, etc. |
| hitPoints | int | HP value |
| trainer | Trainer | FK reference to Trainer |

---

## 🔗 Relationship
Each **Trainer can have many Pokémon**

---

## 🚀 Features

### ✔️ Trainer Features
- Create a trainer
- Get all trainers
- Update a trainer
- Delete a trainer
- Search trainers by:
    - name (contains)
    - region (exact)
    - level (minimum or maximum)

---

### ✔️ Pokémon Features
- Create Pokémon
- Assign Pokemon To Trainer
- Get all Pokémon
- Update Pokémon
- Delete Pokémon
- Search Pokémon by:
    - name (contains)
    - type (exact)
    - hitPoints min/max
    - trainer name (contains)