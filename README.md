# Zadanie rekrutacyjne

Prosta aplikacja Spring Boot pobierająca i zwracająca listę repozytoriów (oprócz fork) oraz branchy użytkownika GitHub

## Wymagania
- Java 21
- Maven
- Dostęp do internetu (wykorzystuje publiczne API GitHub)

## Uruchomienie
1. Klonowanie repozytorium
```bash
git clone https://github.com/RaghRoog/zadanie_rekrutacyjne.git
cd zadanie_rekrutacyjne
```
2. Budowanie i uruchamianie aplikacji
```bash
./mvnw spring-boot:run
```
3. Aplikacja uruchomi się na porcie 8080

## API
1. GET /api/github/{username} - zwraca listę repozytoriów (bez forków) użytkownika {username}, wraz z listą branchy każdego repozytorium

2. Przykład wywołania
http://localhost:8080/api/github/raghroog
3. Przykładowa odpowiedź
```json
[
  {
    "name": "calculator",
    "ownerLogin": "RaghRoog",
    "branches": [
      {
        "name": "main",
        "lastCommitSha": "6619d60ccc52aa493c8483fb02b3f5474f4eb02a"
      }
    ]
  },
  {
    "name": "clock",
    "ownerLogin": "RaghRoog",
    "branches": [
      {
        "name": "main",
        "lastCommitSha": "7b6262daa1fab752243eaa96d5a20e670477833d"
      }
    ]
  }
]
```

## Testy
Aplikacja posiada test integracyjny, który:
- wykonuje żądanie do endpointa /api/github/microsoft
- sprawdza poprawność odpowiedzi i strukturę danych
- łączy się bezpośrednio z GitHub API (brack mocków)

Uruchamianie testów
```bash
./mvnw test
```

## Autor
Szymon Pomieciński - [szumon612@interia.pl](mailto:szumon612@interia.pl)

