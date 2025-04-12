package menu;

import infor.Infor;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuEdit {


    public static void editStudent(Scanner scanner, List<Infor> studentList) {
        System.out.println("\n--- Edit Student Information ---");

        if (studentList.isEmpty()) {
            System.out.println("No students available to edit.");
            return;
        }


        Infor studentToEdit = findStudentById(scanner, studentList);

        if (studentToEdit == null) {
            System.out.println("Student not found or invalid ID entered.");
            return;
        }


        boolean editing = true;
        while (editing) {
            System.out.println("\nEditing Student: " + studentToEdit);
                displayEditOptions();
            int editChoice = selectEditOption(scanner);

            switch (editChoice) {
                case 1:
                    editFullName(scanner, studentToEdit);
                    break;
                case 2:
                    editAge(scanner, studentToEdit);
                    break;
                case 3:
                    editGpa(scanner, studentToEdit);
                    break;
                case 0:
                    System.out.println("Finished editing student ID: " + studentToEdit.getId());
                    editing = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

    }


    private static Infor findStudentById(Scanner scanner, List<Infor> studentList) {
        System.out.print("Enter the ID of the student to edit (e.g., SV001): ");
        String idToEdit = scanner.nextLine().trim().toUpperCase();

        for (Infor student : studentList) {
            if (student.getId().equalsIgnoreCase(idToEdit)) {
                return student;
            }
        }
        return null;
    }


    private static void displayEditOptions() {
        System.out.println("Choose field to edit:");
        System.out.println("[1] - Full Name");
        System.out.println("[2] - Age");
        System.out.println("[3] - GPA");
        System.out.println("[0] - Done Editing This Student");
        System.out.print("Enter your choice: ");
    }


    private static int selectEditOption(Scanner scanner) {
        int choice = -1;
        while (true) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                if (choice >= 0 && choice <= 3) {
                    return choice;
                } else {
                    System.out.println("Invalid choice. Please enter 0, 1, 2, or 3.");
                    System.out.print("Enter your choice: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                scanner.nextLine();
                System.out.print("Enter your choice: ");
            }
        }
    }



    private static void editFullName(Scanner scanner, Infor student) {
        String newName = "";
        while (newName.isEmpty()) {
            System.out.print("Enter new full name (current: " + student.getFullName() + "): ");
            newName = scanner.nextLine().trim();
            if (newName.isEmpty()) {
                System.out.println("Name cannot be empty.");
            } else {
                student.setFullName(newName);
                System.out.println("Full name updated.");
            }
        }
    }

    private static void editAge(Scanner scanner, Infor student) {
        int newAge = -1;
        while (newAge < 0) {
            System.out.print("Enter new age (current: " + student.getAge() + "): ");
            try {
                newAge = scanner.nextInt();
                scanner.nextLine();
                if (newAge <= 0) {
                    System.out.println("Age must be a positive number.");
                    newAge = -1;
                } else {
                    student.setAge(newAge);
                    System.out.println("Age updated.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next();
                scanner.nextLine();
                newAge = -1;
            }
        }
    }

    private static void editGpa(Scanner scanner, Infor student) {
        float newGpa = -1.0f;
        while (newGpa < 0.0f || newGpa > 4.0f) {
            System.out.print("Enter new GPA (0.0 - 4.0) (current: " + String.format("%.2f", student.getGpa()) + "): ");
            try {
                newGpa = scanner.nextFloat();
                scanner.nextLine();

                if (newGpa < 0.0f || newGpa > 4.0f) {
                    System.out.println("Invalid GPA. Must be between 0.0 and 4.0.");

                } else {
                    student.setGpa(newGpa);
                    System.out.println("GPA updated.");

                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number (e.g., 3.5).");
                scanner.next();
                scanner.nextLine();
                newGpa = -1.0f;
            }
        }
    }
}