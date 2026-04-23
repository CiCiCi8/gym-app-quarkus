# Gym App (Quarkus)

Jednostavna backend aplikacija za upravljanje članovima teretane.

## Tehnologije

* Java 21
* Quarkus
* PostgreSQL
* Keycloak (OIDC autentifikacija)

## Funkcionalnosti

* Dodavanje člana
* Pregled svih članova
* REST API
* Autentifikacija i zaštita endpointa pomoću Keycloak-a

## Pokretanje

1. Pokrenuti PostgreSQL
2. Kreirati bazu
3. Podesiti `application.properties`
4. Pokrenuti aplikaciju:

```
./mvnw quarkus:dev
```

Aplikacija radi na: http://localhost:8081

## Endpointi

* POST /addmember
* GET /getmembers

## Autentifikacija (Keycloak)

Aplikacija koristi Keycloak za autentifikaciju i zaštitu endpointa.

### Dobijanje tokena

POST http://localhost:8080/realms/gym-app-quarkus/protocol/openid-connect/token

Body (x-www-form-urlencoded):

* client_id: gym-client
* client_secret: <client_secret>
* username: adminuser
* password: admin123
* grant_type: password

### Korišćenje tokena

Za zaštićene endpointe potrebno je poslati Bearer token:

```
Authorization: Bearer <access_token>
```

### Zaštićeni endpointi

* GET /getmembers
* POST /addmember

## Napomena

Svi endpointi su zaštićeni i zahtijevaju validan access token.

## Autor

Momčilo Kovačević
