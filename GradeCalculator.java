import java.util.InputMismatchException;
import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the student grade calculator! Let's help you calculate your grades.");

        int subjects = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter the number of subjects to calculate: ");
                subjects = scanner.nextInt();

                if (subjects <= 0) {
                    System.out.println("Please enter a positive number of subjects.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.next();
            }
        }

        double totalGrades = 0;

        for (int i = 1; i <= subjects; i++) {
            double grade = -1;
            boolean validGrade = false;

            while (!validGrade) {
                try {
                    System.out.print("Enter grade for subject " + i + " (0-100): ");
                    grade = scanner.nextDouble();

                    if (grade < 0 || grade > 100) {
                        System.out.println("Invalid grade! Please enter a value between 0 and 100.");
                    } else {
                        validGrade = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a valid number.");
                    scanner.next();
                }
            }

            totalGrades += grade;
        }

        double average = totalGrades / subjects;
        String formattedAverage = String.format("%.2f", average);

        int level;
        if (average >= 80) level = 7;
        else if (average >= 70) level = 6;
        else if (average >= 60) level = 5;
        else if (average >= 50) level = 4;
        else if (average >= 40) level = 3;
        else if (average >= 30) level = 2;
        else level = 1;

        System.out.println("Your average grade is: " + formattedAverage + "%.");
        System.out.println("Which is a Level " + level + " achievement.");

        scanner.close();
    }
}