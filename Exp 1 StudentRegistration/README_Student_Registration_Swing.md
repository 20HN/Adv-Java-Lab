# Student Registration Form Using Java Swing

## Overview
This practical demonstrates a graphical user interface (GUI) for student registration using Java Swing. The form collects a student's name, roll number, gender, and branch, and requires acceptance of the terms and conditions.

## Features
- Student name, roll number, and branch input fields
- Male/Female radio-button selection
- Terms and conditions checkbox
- Submit and Reset buttons
- Validation for required fields
- Success message after valid submission

## Technologies
- Java
- Java Swing (`javax.swing`)
- AWT event handling (`java.awt.event`)
- `JFrame`, `JLabel`, `JTextField`, `JRadioButton`, `ButtonGroup`, `JCheckBox`, `JButton`, and `JOptionPane`

## How It Works
1. The `StudentRegistration` class extends `JFrame` to create the application window.
2. Swing components are added to the frame and positioned.
3. The class implements `ActionListener` to handle button clicks.
4. **Submit** validates the required fields and terms acceptance before displaying a success message.
5. **Reset** clears the text fields, gender selection, and checkbox.

## Run
1. Install a Java JDK.
2. Save the source code in `StudentRegistration.java`.
3. Compile:
   ```bash
   javac StudentRegistration.java
   ```
4. Run:
   ```bash
   java StudentRegistration
   ```

## Notes
- The source document uses absolute positioning with `setLayout(null)` and `setBounds()`.
- Ensure the public class name and filename match.
