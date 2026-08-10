# 🛠️ Repair Service Management System - Backend API

Serwerowa część aplikacji (REST API) służącej do kompleksowego zarządzania serwisem naprawczym. System udostępnia endpointy do ewidencji klientów, rejestracji sprzętu oraz zarządzania cyklem życia zleceń.

> 🖥️ **Kod interfejsu użytkownika (Frontend / React) do tego API znajdziesz w repozytorium:** `https://github.com/K-Krupa/repair-frontend`

Projekt został zbudowany z naciskiem na **czystą architekturę**, **obsługę błędów** oraz **najlepsze praktyki inżynierii oprogramowania**.

## ✨ Główne funkcjonalności

*   **Zarządzanie relacyjne (CRUD):** Obsługa powiązanych ze sobą encji Klienta, Sprzętu i Zlecenia.
*   **Optymalizacja bazy danych:** Zapobieganie problemowi N+1 zapytań poprzez wykorzystanie opóźnionego ładowania powiązań (`FetchType.LAZY`).
*   **Scentralizowana obsługa wyjątków:** Globalny `GlobalExceptionHandler` przechwytujący błędy i zwracający ustandaryzowane odpowiedzi HTTP (np. HTTP 400 dla błędów walidacji, HTTP 404 dla braku zasobów).
*   **Solidna walidacja danych:** Zabezpieczenie danych wejściowych za pomocą specyfikacji Jakarta Validation (`@NotNull`, `@NotBlank`, `@Size`).
*   **Bezpieczeństwo konfiguracji:** Zastosowanie zmiennych środowiskowych do izolacji poświadczeń bazy danych, aby uniknąć wycieku haseł.
*   **Automatyczna dokumentacja:** Zintegrowany interfejs Swagger UI ułatwiający eksplorację endpointów.

## 💻 Technologie

*   Java (JDK 17+)
*   Spring Boot 3
*   Spring Data JPA / Hibernate
*   Baza danych: PostgreSQL
*   JUnit 5 & Mockito (Testy jednostkowe)
*   Springdoc OpenAPI (Swagger)

## 🚀 Uruchomienie lokalne

1. Sklonuj repozytorium:
   git clone https://github.com/K-Krupa/repair-service

2. Zdefiniuj zmienną środowiskową dla hasła do bazy danych:
    * **Zmienna:** `DB_PASSWORD`
    * **Wartość:** `<twoje_hasło_do_bazy>`

3. Uruchom aplikację:
   ./mvnw spring-boot:run

4. Dokumentacja API (Swagger) będzie dostępna pod adresem:
   http://localhost:8080/swagger-ui.html

## 🧪 Testy
Projekt posiada zaimplementowane testy jednostkowe weryfikujące kluczową logikę biznesową z wykorzystaniem frameworków **JUnit 5** oraz **Mockito**. Weryfikują one zarówno pozytywne ścieżki (zmiany statusów), jak i negatywne (rzucanie odpowiednich wyjątków). Aby uruchomić testy:

./mvnw test

## 👨‍💻 Autor
**Kacper Krupa**