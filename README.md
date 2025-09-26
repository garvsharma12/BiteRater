# BiteRater 🍽️

BiteRater is a **restaurant discovery and review platform** that enables users to find local restaurants, read authentic reviews, and share their dining experiences.  
It integrates **Spring Boot**, **Elasticsearch**, **Keycloak**, and **Next.js** to deliver a modern, secure, and scalable solution.

---

## 🚀 Features

- 🔍 **Search & Discovery**  
  - Full-text and fuzzy search powered by Elasticsearch  
  - Geospatial search to find nearby restaurants  
  - Filter by cuisine, rating, and location  

- 🏪 **Restaurant Management**  
  - Add and manage restaurants with details like address, operating hours, and photos  
  - Display average ratings from user reviews  

- ✍️ **Reviews & Ratings**  
  - Users can write reviews with text, star ratings, and photos  
  - Reviews are editable within 48 hours  
  - Multiple photos per review  

- 🔐 **Authentication & Security**  
  - Powered by **Keycloak** (OAuth2 + OpenID Connect)  
  - Role-based access control (restaurant owners vs. regular users)  

- 🖼️ **Photo Uploads**  
  - Attach photos to restaurants and reviews  
  - Metadata (captions, timestamps) stored alongside images  

- 🌐 **Frontend**  
  - Built with **Next.js**  
  - Intuitive UI with restaurant cards, maps, and review submission forms  

---

## 🏗️ System Architecture

- **Frontend**: Next.js (React-based UI, running on Node.js)  
- **Backend**: Spring Boot (REST APIs, business logic, security)  
- **Database**: Elasticsearch (document-based storage with search capabilities)  
- **Auth Server**: Keycloak (OAuth2 + OIDC)  
- **Infrastructure**: Docker & Docker Compose (Elasticsearch, Kibana, Keycloak)  

---

## ⚙️ Tech Stack

- **Java 21**, **Spring Boot 3**, **Spring Security**  
- **Elasticsearch** + **Kibana**  
- **Keycloak**  
- **Next.js** (Node.js 20+)  
- **Maven** for dependency management  
- **Docker Compose** for local setup  

---

## 📦 Prerequisites

- [Java 21+](https://adoptium.net)  
- [Node.js 20+](https://nodejs.org)  
- [Docker](https://www.docker.com) & Docker Compose  
- IDE (IntelliJ IDEA recommended)  

---

## 🔧 Setup & Run

### 1. Clone the repository
```bash
git clone https://github.com/yourusername/biterater.git
cd biterater

---

## 🏗️ System Architecture

```mermaid
flowchart TD
    subgraph Client
        UI[Next.js Frontend] -->|REST API| Backend
    end

    subgraph Backend
        SB[Spring Boot Application]
    end

    subgraph Services
        ES[(Elasticsearch)]
        KC[Keycloak]
    end

    SB --> ES
    SB --> KC

    Backend --> Services
