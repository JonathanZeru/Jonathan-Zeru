# M-PESA - Kotlin Money Transfer App

This is a Kotlin Android app project demonstrating a simple money transfer system with multiple screens including adding money, sending to bank, confirmation, and viewing recent transfer history.

---

## Project Structure
C:.
│ MainActivity.kt
│
├───data
│ AppDatabase.kt
│ Transfer.kt
│ TransferDao.kt
│
├───di
│ DatabaseModule.kt
│
├───model
│ TransferViewModel.kt
│
├───navigator
│ MyNavHost.kt
│
├───screenshots
│ AddMoneyScreen.png
│ AddMoneyScreenDetail-1.png
│ AddMoneyScreenDetail-2.png
│ ConfirmationScreen.png
│ HomeScreen.png
│ SendToBankScreen.png
│
├───store
└───ui
├───components
│ AddMoneyCard.kt
│ CustomInput.kt
│ StackedAvatar.kt
│ SwipeRefreshLayout.kt
│
├───screens
│ AddMoneyScreen.kt
│ AddMoneyScreenDetail.kt
│ ConfirmationScreen.kt
│ HomeScreen.kt
│ RecentHistoryScreen.kt
│ SendToBankScreen.kt
│
└───theme


---

## Screens & Features

### 1. Home Screen  
![Home Screen]
<img src="https://github.com/JonathanZeru/Jonathan-Zeru/blob/main/app/src/main/java/com/mpesa/myapplication/screenshots/HomeScreen.png" alt="Add Money Screen" width="400" />

The main dashboard where users can navigate to add money, send money, or view recent transfers.

---

### 2. Add Money Screen  
![Add Money Screen](https://github.com/JonathanZeru/Jonathan-Zeru/blob/main/app/src/main/java/com/mpesa/myapplication/screenshots/AddMoneyScreen.png)  
The screen to input the amount to add and select the funding source.

---

### 3. Add Money Details  
![Add Money Detail 1](https://github.com/JonathanZeru/Jonathan-Zeru/blob/main/app/src/main/java/com/mpesa/myapplication/screenshots/AddMoneyScreenDetail-1.png)  

![Add Money Detail 2](https://github.com/JonathanZeru/Jonathan-Zeru/blob/main/app/src/main/java/com/mpesa/myapplication/screenshots/AddMoneyScreenDetail-2.png)  
These screens provide detailed options and confirmation inputs before processing the money addition.

### 4. Send To Bank Screen  
![Send To Bank Screen](https://github.com/JonathanZeru/Jonathan-Zeru/blob/main/app/src/main/java/com/mpesa/myapplication/screenshots/SendToBankScreen.png)  
Allows the user to transfer money to a linked bank account, including recipient selection and amount input.

### 5. Confirmation Screen  
![Confirmation Screen](https://github.com/JonathanZeru/Jonathan-Zeru/blob/main/app/src/main/java/com/mpesa/myapplication/screenshots/ConfirmationScreen.png)  
Final confirmation page showing transfer details and success message.

