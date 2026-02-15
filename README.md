# GitHub User - Kotlin Multiplatform

A robust, cross-platform application for searching and exploring GitHub users, built using **Kotlin Multiplatform (KMP)** and **Compose Multiplatform**. This project demonstrates a high-level adherence to Clean Architecture and modern reactive programming across Android, iOS, and Desktop (JVM).

## Evaluation Criteria & Implementation

This project is built to satisfy industry-standard evaluation metrics, adapting Android-specific requirements into a **Multiplatform** context.

### 1. Feature Implementation

* **Search Screen:** Fully implemented screen allowing real-time GitHub user searches.
* **Networking:** Utilizes **Ktor** and **Ktorfit** (the Multiplatform-ready alternative to Retrofit/OkHttp) for type-safe API interactions.
* **Display:** Search results are rendered using a shared `LazyColumn` (the Multiplatform equivalent of RecyclerView).


* **User List Screen:** Displays a comprehensive list of users featuring usernames and avatars.
* **Image Loading:** Powered by `io.github.qdsfdhvh:image-loader` to ensure efficient image caching and loading across all targets (Multiplatform alternative to Glide).


* **User Detail Screen:** Detailed view providing profile-specific information, including avatars, bios, and other relevant metadata.
* **Local Data Persistence:** Implemented using **Room Multiplatform** for local database storage.
* Ensures robust data caching and offline retrieval capabilities.



### 2. Architecture & Technical Standards

* **Clean Architecture & Modularization:** The project is strictly modularized into: `:data (local & remote)`, `:domain`, `:presentation`, `:core`, and `:core-ui`.
* Clear separation of concerns between layers.


* **Design Pattern:** Implements the **MVI (Model-View-Intent)** pattern for predictable state management.
* **Dependency Injection:** Managed via **Koin**, providing a lightweight and KMP-native DI solution.
* **Concurrency:** Full utilization of **Kotlin Coroutines** and **Flow** for asynchronous operations and reactive data streams.
* Uses **Jetpack Lifecycle (ViewModel)** components optimized for Compose Multiplatform.


* **Debugging:** Integrated **Chucker** (Android target) for real-time network interception and inspection.
* **Git History:** Maintained a clean, descriptive, and professional Git history to track project evolution.

---

## Project Structure

This project adopts a highly modular **Clean Architecture** approach. Each module is designed to be multiplatform-ready, containing its own platform-specific source sets to handle platform-dependent implementations.

### Modular Architecture

The codebase is partitioned into specialized modules to ensure a strict separation of concerns:

* **`:domain`**: The central layer containing Business Logic, Model, and Use Cases.
* **`:data`**: Responsible for data sourcing and is further divided into:
* **`:local`**: Manages local persistence using **Room Multiplatform**.
* **`:remote`**: Handles network communication via **Ktorfit**.


* **`:core`** & **`:core-ui`**: Houses shared utilities, base classes, and reusable UI components.
* **`:shared`**: A coordination module that aggregates for the presentation layer.
* **`:composeApp`**: The primary entry point for the **Compose Multiplatform** UI.

### Source Set Organization

Each of the modules above (where applicable) follows the Kotlin Multiplatform source set structure:

* **`commonMain`**: Contains shared business logic, interfaces, and declarations common to all platforms.
* **`androidMain`**: Holds Android-specific implementations and configurations.
* **`appleMain`**: Contains logic specific to Apple platforms (iOS), such as native drivers or APIs.
* **`desktopMain`**: Dedicated to JVM Desktop-specific code.

### Native Entry Points

* **[`/iosApp`](https://www.google.com/search?q=./iosApp)**: The native Xcode project required to bootstrap and run the application on iOS devices.

---

## Build and Run Instructions

### Android Application

To build and run the development version of the Android app:

* **macOS/Linux:** `./gradlew :composeApp:assembleDebug`
* **Windows:** `.\gradlew.bat :composeApp:assembleDebug`

###  Desktop (JVM) Application

To build and run the desktop version:

* **macOS/Linux:** `./gradlew :composeApp:run`
* **Windows:** `.\gradlew.bat :composeApp:run`

### iOS Application

1. Open the `/iosApp` directory in **Xcode**.
2. Select your target simulator or physical device.
3. Build and run directly from Xcode or via the IDE run widget.

> [!IMPORTANT]
> This project currently targets **Android, iOS, and Desktop (JVM)**. Web support (`wasmJs` / `Js`) is not enabled in the current configuration.

---

