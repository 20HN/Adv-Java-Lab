# Calculator Using Java Swing and MVC Architecture

## Overview
This practical develops a basic arithmetic calculator with Java Swing, organized using the Model–View–Controller (MVC) pattern.

## Features
- Input fields for two numbers
- Addition, subtraction, multiplication, and division
- Result field that is not directly editable
- Separate Model, View, Controller, and Main classes

## MVC Structure
- **Model (`CalculatorModel`)**: Performs arithmetic operations.
- **View (`CalculatorView`)**: Displays the GUI components and input/output fields.
- **Controller (`CalculatorController`)**: Receives button events, reads inputs, calls the model, and updates the result.
- **Main (`Main`)**: Creates the view and model and connects them through the controller.

## Technologies
- Java
- Java Swing (`javax.swing`)
- Event handling (`java.awt.event.ActionListener`)

## Run
Keep the classes in the same source folder (or configure packages consistently):
1. Compile:
   ```bash
   javac *.java
   ```
2. Run:
   ```bash
   java Main
   ```

## Notes
- The supplied example returns `0` for division by zero.
- The controller parses input using `Double.parseDouble`; non-numeric or empty input will need error handling in a more robust version.
