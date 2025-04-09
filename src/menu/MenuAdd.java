package menu;

import infor.Infor;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuAdd {

    public static void addStudent(Scanner scanner, List<Infor> studentList) {
        System.out.println("\n--- Add New Student ---");

        String name = "";
        int age = -1;
        float gpa = -1.0f;

        while (name.isEmpty()) {
            System.out.print("Enter full name: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty. Please try again.");
            }
        }


        while (age < 0) {
            System.out.print("Enter age: ");
            try {
                age = scanner.nextInt();
                if (age <= 0) {
                    System.out.println("Age must be a positive number.");
                    age = -1;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a whole number for age.");
                scanner.next();
                age = -1;
            } finally {

                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
        }


        while (gpa < 0.0f || gpa > 4.0f) {
            System.out.print("Enter GPA (0.0 - 4.0): ");
            try {
                gpa = scanner.nextFloat();


                if (gpa < 0.0f || gpa > 4.0f) {
                    System.out.println("Invalid GPA. GPA must be between 0.0 and 4.0 (inclusive).");

                }


            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number for GPA (e.g., 3.5).");
                scanner.next();
                gpa = -1.0f;
            } finally {

                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
        }


        Infor newStudent = new Infor(null, name, age, gpa);
        studentList.add(newStudent);
        System.out.println("Student added successfully!");
        System.out.println("New Student Details: " + newStudent);
    }


}