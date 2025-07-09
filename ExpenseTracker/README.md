# Expense Tracker

**Author:** Vishal Thakur  
**Email:** vishalthakurx@gmail.com  
**GitHub:** [@vishalthakurx](https://github.com/vishalthakurx)

## Description
A simple expense tracking application with file persistence using Java serialization.

## Features
- Add new expenses with description and amount
- List all recorded expenses
- Persistent storage using serialization
- Automatic data loading on startup
- Clean console interface

## How to Run
```bash
javac ExpenseTracker.java
java ExpenseTracker
```

## Data Storage
- Expenses are saved to `expenses.ser` file
- Data persists between program runs
- Uses Java object serialization

## Menu Options
1. **Add**: Record a new expense
2. **List**: Display all expenses
3. **Save & Exit**: Save data and quit

## Concepts Demonstrated
- **Serialization**: Object persistence to file
- **File I/O**: ObjectInputStream and ObjectOutputStream
- **Collections**: ArrayList for data management
- **Exception Handling**: Graceful error handling
- **Encapsulation**: Expense class design

## Educational Value
Great for learning data persistence, serialization, and basic file handling in Java applications.
