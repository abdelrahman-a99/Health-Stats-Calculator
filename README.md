# Health Stats Calculator

## Overview
This Java application allows users to input information about individuals such as their name, age, weight, height, and gender, and then calculates their Basal Metabolic Rate (BMR), Body Mass Index (BMI), and weight status based on the calculated BMI. It also provides functionalities to find persons with the highest BMI values and calculate the average BMR value per gender for individuals within the optimal weight range.

## Usage
1. **Clone the Repository**: Clone this repository to your local machine using the command:
    ```
    git clone <repository-url>
    ```

2. **Compile**: Compile the Java files using any Java compiler. You can use an IDE like IntelliJ IDEA, Eclipse, or compile manually using the command line.

3. **Run**: Execute the Main class to start the program. Follow the instructions in the console to input the details of individuals.

4. **View Results**: After inputting the details of individuals, the program will display the persons with the highest BMI values and the average BMR value per gender for individuals within the optimal weight range.

5. **Check Output**: Additionally, the program writes the results to a binary file named `Report.dat` located in the `Q1` directory.

## Directory Structure
- `Q1`: Contains the source code for the project.
  - `Main.java`: Main class to run the program.
  - `Person.java`: Class to represent an individual and calculate BMR, BMI, and weight status.
  - `Calculator.java`: Class containing methods to perform calculations and write data to a binary file.
  - `Gender.java`: Enum representing the gender of an individual.
- `README.md`: This file providing an overview of the project and instructions for usage.

## Dependencies
- Java Development Kit (JDK) 8 or higher

## Notes
- Ensure that you have the necessary permissions to write files to the directory where the program is executed, as the program writes data to a binary file.
- The program assumes valid input for simplicity. Ensure that input follows the expected format to avoid errors.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
