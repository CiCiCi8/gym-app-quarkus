# Gym App (Quarkus)

Jednostavna backend aplikacija za upravljanje članovima teretane.

## Tehnologije
- Java 21
- Quarkus
- PostgreSQL

## Funkcionalnosti
- Dodavanje člana
- Pregled svih članova
- REST API

## Pokretanje
1. Pokrenuti PostgreSQL
2. Kreirati bazu
3. Podesiti `application.properties`
4. Pokrenuti:

./mvnw quarkus:dev

Aplikacija radi na:
http://localhost:8081

## Endpointi

POST /addmember  
GET /getmembers

## Autor
Momčilo Kovačević
