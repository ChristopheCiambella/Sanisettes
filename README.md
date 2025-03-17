# MOB-Android Test Technique – Public Toilets

This project is an Android application developed as a technical test for displaying and managing public toilets in Paris. The app fetches data from the RATP Open Data API and displays a list of public toilets along with key details.

---

## Table of Contents

- [Objective](#objective)
- [Features](#features)
- [Architecture & Technologies](#architecture--technologies)
- [Installation & Running](#installation--running)
- [Unit Tests](#unit-tests)
- [Improvements & Bonus Features](#improvements--bonus-features)
- [Conclusion](#conclusion)

---

## Objective

The goal of this application is to:

- Retrieve a list of public toilets in Paris using the RATP Open Data API (dataset **sanisettesparis2011**).
- Display for each toilet:
    - The full address
    - Opening hours
    - Accessibility for people with reduced mobility (PMR)
    - The distance from the current location (if location permission is granted)
- Allow the user to filter the list to display only PMR-accessible toilets.

---

## Features

### Main Features

- **Toilet List**  
  Display a detailed list showing the address, opening hours, and PMR accessibility of each public toilet.

- **Distance Calculation**  
  Show the distance between the current location and each toilet (if permission is granted).

- **PMR Filter**  
  Provide a switch in the top app bar that lets users toggle a filter to display only toilets accessible for people with reduced mobility.

### Bonus Features

- **Toilet Details Screen**  
  Navigate to a dedicated detail screen when a toilet is selected.

- **Interactive Map**  
  Display toilets on a map with markers that are styled differently based on their PMR accessibility.

- **External Navigation**  
  Allow opening the toilet’s address in an external mapping application to display directions.

---

## Architecture & Technologies

### Architecture

This project follows Clean Architecture principles:

- **Domain**  
  Contains pure business logic (use cases, models, and abstract interfaces).

- **Data**  
  Handles network calls, persistence (e.g., DataStore), and mappers (e.g., `RecordsResponseMapper`).

- **Presentation**  
  Implemented using Jetpack Compose for UI and navigation.

- **Dependency Injection**  
  Utilizes Koin to inject dependencies without tying the domain layer to Android-specific classes.

### Technologies Used

- **Kotlin** – Primary programming language.
- **Jetpack Compose** – Declarative UI framework.
- **Navigation Compose** – Manages navigation between screens.
- **Koin** – Dependency injection framework.
- **Kotlinx Serialization** – Serializes/deserializes JSON for passing complex objects between screens.
- **DataStore** – Persists preferences (e.g., PMR filter).
- **Google Maps Compose** – (Bonus) Displays maps with custom markers.

---

## Installation & Running

### Prerequisites

- Android Studio (Bumblebee or later)
- Android SDK 31 or higher
- Internet connection (to access the Open Data API)

### Steps

1. **Clone the Repository**

2. **Open the Project in Android Studio**

    - Open Android Studio and choose **File > Open**.
    - Select the project directory.

3. **Build the Project**

    - Let Gradle download all required dependencies (Koin, Jetpack Compose, etc.).

4. **Run the Application**

    - Choose an emulator or a physical device.
    - Click the **Run** button in Android Studio.

---

## Unit Tests

The project includes unit tests for the business logic, for example, testing the `RecordsResponseMapper` class. These tests ensure that:

- The `nextOffset` is calculated correctly.
- The mapping filters out `null` values as expected.
- Edge cases (such as an empty response or an offset exceeding the total count) are handled properly.

You can run the tests using Android Studio's test runner or from the command line:

```bash
./gradlew test
````
---

## Improvements & Bonus Features

### Possible Improvements

- Optimize Distance Calculation
  Enhance the distance calculation (e.g., using the Haversine formula).

- Enhanced Permission Handling
  Improve the request and management of location permissions.

### Implemented Bonus Features

- Toilet Details Screen
  Navigate to a dedicated screen that displays complete details of a selected toilet.

- Interactive Map
  Display toilets on a map with custom markers differentiating PMR-accessible toilets.

- External Navigation Integration
  Provide an option to open the toilet’s address in an external navigation app to display directions.

---

## Conclusion
This project meets the technical test requirements by providing a functional, well-architected, and easily extensible Android application. The code demonstrates modern Android development practices, including Clean Architecture, Jetpack Compose, Koin for dependency injection, and more.

If you have any questions or suggestions, please feel free to contact me.

This project was developed as part of a technical test to demonstrate proficiency in modern Android technologies and best practices in application architecture.