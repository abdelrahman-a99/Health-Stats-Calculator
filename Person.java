package Q1;

public class Person {
    // Private attrbutes
    private String name;
    private int age;
    private double weight;
    private double height;
    private Gender gender;

    // Default constructor
    public Person() {
        this.name = "UNKNOWN";
        this.age = 0;
        this.weight = 0.0;
        this.height = 0.0;
        this.gender = Gender.UNKNOWN;
    }

    // Parameterized constructor
    public Person(String name, int age, double weight, double height, Gender gender) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public Gender getGender() {
        return gender;
    }

    // Another methods
    public double calc_BMR() {
        double BMR;
        if (gender == Gender.MALE) {
            BMR = 66 + (13.7 * weight) + (5 * height) - (6.8 * age);
        } else {
            BMR = 655 + (9.6 * weight) + (1.8 * height) - (4.7 * age);
        }
        return Double.parseDouble(String.format("%.2f", BMR));
        // return BMR;
    }

    public double calc_BMI() {
        double BMI = weight / Math.pow(height / 100, 2); // (100 * height) -> wrong calculation
        return Double.parseDouble(String.format("%.2f", BMI));
        // return weight / Math.pow(height / 100, 2);
    }

    public String Weight_Status() {
        if (calc_BMI() < 18.5) {
            return "Underweight";
        } else if (calc_BMI() >= 18.5 && calc_BMI() <= 25) {
            return "Optimal weight";
        } else {
            return "Overweight";
        }
    }
}
