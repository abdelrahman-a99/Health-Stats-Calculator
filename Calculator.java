package Q1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Calculator {
    private List<Person> persons = new ArrayList<>();

    // Add person to the list
    public void addPerson(Person person) {
        persons.add(person);
    }

    // Get all persons
    public List<Person> getPersons() {
        return persons;
    }

    // ============================================================================================================

    // Write data to a binary file
    public void writeDataToBinaryFile(String filename) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            for (Person person : persons) {
                dos.writeUTF("Name: " + person.getName() + ", Age: " + person.getAge() +
                        ", Weight: " + person.getWeight() + ", Height: " + person.getHeight() +
                        ", Gender: " + person.getGender() + ", BMR: " + person.calc_BMR() +
                        ", BMI: " + person.calc_BMI() + ", Weight Status: " + person.Weight_Status() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ============================================================================================================

    // Find persons with the highest BMI values
    public void findPersonsHighestBMI() {
        double maxBMI = 0.0;
        List<Person> personsWithHighestBMI = new ArrayList<>();

        for (Person person : persons) {
            double bmi = person.calc_BMI();
            if (bmi > maxBMI) {
                maxBMI = bmi;
                personsWithHighestBMI.clear();
                personsWithHighestBMI.add(person);
            } else if (bmi == maxBMI) {
                personsWithHighestBMI.add(person);
            }
        }

        // Print details of persons with the highest BMI values
        System.out.println("\nPersons with the highest BMI:");
        for (Person person : personsWithHighestBMI) {
            System.out.println("Name: " + person.getName() + ", BMI: " + person.calc_BMI() + "\n");

            System.out.println("The Details of " + person.getName() + ":");
            System.out.println("Name: " + person.getName() + ", Age: " + person.getAge() +
                    ", Weight: " + person.getWeight() + ", Height: " + person.getHeight() +
                    ", Gender: " + person.getGender() + ", BMR: " + person.calc_BMR() +
                    ", BMI: " + person.calc_BMI() + ", Weight Status: " + person.Weight_Status() + "\n");
        }

        // Write details of persons with the highest BMI values to binary file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("Q1/Report.dat"))) {
            dos.writeUTF("Persons with the highest BMI:\n");
            for (Person person : personsWithHighestBMI) {
                dos.writeUTF("Name: " + person.getName() + ", BMI: " + person.calc_BMI() + "\n");
                dos.writeUTF("The Details of " + person.getName() + ":" + "\n");
                dos.writeUTF("Name: " + person.getName() + ", Age: " + person.getAge() +
                        ", Weight: " + person.getWeight() + ", Height: " + person.getHeight() +
                        ", Gender: " + person.getGender() + ", BMR: " + person.calc_BMR() +
                        ", BMI: " + person.calc_BMI() + ", Weight Status: " + person.Weight_Status() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ============================================================================================================

    // Calculate the average BMR value per gender for Optimal weighted persons
    public void calcAvgBMRPerGenderForOptimalWeightedPersons() {
        double totalBMRMale = 0;
        double totalBMRFemale = 0;
        int countMale = 0;
        int countFemale = 0;

        for (Person person : persons) {
            double bmi = person.calc_BMI();
            if (bmi >= 18.5 && bmi <= 25) {
                double bmr = person.calc_BMR();
                if (person.getGender() == Gender.MALE) {
                    totalBMRMale += bmr;
                    countMale++;
                } else if (person.getGender() == Gender.FEMALE) {
                    totalBMRFemale += bmr;
                    countFemale++;
                }
            }
        }

        // Print average BMR value per gender for Optimal weighted persons
        System.out.println("Average BMR value per gender for Optimal weighted persons:");

        if (countMale > 0) {
            System.out.println("Male: " + (totalBMRMale / countMale));
        } else {
            System.out.println("No males within the optimal weight range.");
        }
        if (countFemale > 0) {
            System.out.println("Female: " + (totalBMRFemale / countFemale));
        } else {
            System.out.println("No females within the optimal weight range.");
        }

        // Write average BMR value per gender for Optimal weighted persons to binary file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("Q1/Report.dat", true))) {
            dos.writeUTF("\nAverage BMR value per gender for Optimal weighted persons:\n");
            if (countMale > 0) {
                dos.writeUTF("Male: " + (totalBMRMale / countMale) + "\n");
            } else {
                dos.writeUTF("No males within the optimal weight range.\n");
            }
            if (countFemale > 0) {
                dos.writeUTF("Female: " + (totalBMRFemale / countFemale) + "\n");
            } else {
                dos.writeUTF("No females within the optimal weight range.\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
