package Q1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Calculator calculator = new Calculator();

        int n = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the number of persons: ");
                n = scanner.nextInt();
                scanner.nextLine();

                if (n > 0) {
                    validInput = true;
                } else {
                    System.out.println("Error: Please enter a positive number of persons.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid integer.");
                scanner.nextLine();
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for person " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = 0;
            boolean validAge = false;
            while (!validAge) {
                try {
                    age = scanner.nextInt();
                    if (age > 0) {
                        validAge = true;
                    } else {
                        System.out.println("Error: Age must be a positive integer.");
                        System.out.print("Age: ");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Age must be a valid integer.");
                    System.out.print("Age: ");
                    scanner.next();
                }
            }

            System.out.print("Weight (kg): ");
            double weight = 0;
            boolean validWeight = false;
            while (!validWeight) {
                try {
                    weight = scanner.nextDouble();
                    if (weight > 0) {
                        validWeight = true;
                    } else {
                        System.out.println("Error: Weight must be a positive number.");
                        System.out.print("Weight (kg): ");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Weight must be a valid number.");
                    System.out.print("Weight (kg): ");
                    scanner.next();
                }
            }

            System.out.print("Height (cm): ");
            double height = 0;
            boolean validHeight = false;
            while (!validHeight) {
                try {
                    height = scanner.nextDouble();
                    if (height > 0) {
                        validHeight = true;
                    } else {
                        System.out.println("Error: Height must be a positive number.");
                        System.out.print("Height (cm): ");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Height must be a valid number.");
                    System.out.print("Height (cm): ");
                    scanner.next();
                }
            }
            scanner.nextLine();

            Gender gender = null;
            while (gender == null) {
                System.out.print("Gender (male/female): ");
                String genderStr = scanner.nextLine().trim().toLowerCase();
                if (genderStr.equals("male")) {
                    gender = Gender.MALE;
                } else if (genderStr.equals("female")) {
                    gender = Gender.FEMALE;
                } else {
                    System.out.println("Error: Invalid gender input.");
                }
            }

            Person person = new Person(name, age, weight, height, gender);
            calculator.addPerson(person);
        }

        if (n > 0) {
            calculator.findPersonsHighestBMI();
            calculator.calcAvgBMRPerGenderForOptimalWeightedPersons();
        } else {
            System.out.println("Error: Please enter a positive number of persons.");
        }

        scanner.close();
    }
}
