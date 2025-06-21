# 💰 Currency Converter

## 🧐 Overview

A simple console-based currency converter application developed in Java using the MVC (Model-View-Controller) architecture. The app fetches real-time exchange rates from an external API and converts currency values based on user input.

---
## 🤩 Features

- Fetches live currency exchange rates from [ExchangeRate-API](https://www.exchangerate-api.com/)
- Validates user input against available currencies
- Displays conversion result with 2 decimal precision
- Handles API errors gracefully
- Displays informative messages for invalid input

---
## 🏗️ Architecture

- **Model:** Represents the exchange rate data fetched from the API  
- **Service:** Handles communication with the external API and conversion logic  
- **Controller:** Orchestrates the flow between Service and View  
- **View:** Console-based UI for user interaction and input validation  

---
## 🏃‍♂️How to Run

1. Clone or download the repository.  
2. Make sure you have Java 11+ installed.  
3. Download and include the Gson library (`gson-2.10.1.jar`) in your classpath.  
4. Compile the project.  
5. Run the `View.CurrencyConverterView` class.  

Example command:

```bash
javac -cp gson-2.10.1.jar ./src/**/*.java
java -cp .:gson-2.10.1.jar View.CurrencyConverterView

```
---
## 🌐 Usage
When prompted, enter the source currency code (e.g., USD).
- Enter the target currency code (e.g., BRL).
- Enter the amount to convert.
- The application displays the converted amount.
---
## 🛠️ Improvements and Future Work
1. Add logging with proper logging framework.
2. Show last update and next update time from API data.
3. Improve error handling and input validation.
4. Develop a GUI version.
---
## License
This project is for educational purposes and does not have a specific license.
