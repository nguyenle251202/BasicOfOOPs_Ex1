package menu;

import infor.Infor;
import infor.View;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuSearch {

    public static void showSearchMenu(Scanner scanner, List<Infor> studentList, View studentViewer) {
        System.out.println("\n--- Search Students ---");

        if (studentList.isEmpty()) {
            System.out.println("No students available to search.");
            return;
        }

        while (true) {
            displaySearchOptions();
            int searchChoice = selectSearchOption(scanner);

            if (searchChoice == 0) {
                System.out.println("Returning to main menu.");
                return;
            }

            searchStudent(searchChoice, scanner, studentList, studentViewer);

            System.out.println("\nPress Enter to perform another search or return...");
            scanner.nextLine(); // Pause before showing search menu again
        }
    }

    private static void displaySearchOptions() {
        System.out.println("Search by:");
        System.out.println("[1] - ID (Exact Match)");
        System.out.println("[2] - Full Name (Contains)");
        System.out.println("[3] - Age (Exact Match)");
        System.out.println("[4] - GPA (Exact Match)");
        System.out.println("[0] - Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    private static int selectSearchOption(Scanner scanner) {
        int choice = -1;
        while (true) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (choice >= 0 && choice <= 4) {
                    return choice;
                } else {
                    System.out.println("Invalid choice. Please enter 0, 1, 2, 3, or 4.");
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

    private static void searchStudent(int searchChoice, Scanner scanner, List<Infor> studentList, View studentViewer) {
        List<Infor> searchResults = new ArrayList<>();
        String searchTerm;

        try {
            switch (searchChoice) {
                case 1: // Search by ID
                    System.out.print("Enter ID to search for: ");
                    searchTerm = scanner.nextLine().trim();
                    if (searchTerm.isEmpty()) {
                        System.out.println("Search term cannot be empty.");
                        return;
                    }
                    for (Infor student : studentList) {
                        if (student.getId().equalsIgnoreCase(searchTerm)) {
                            searchResults.add(student);
                        }
                    }
                    break;

                case 2: // Search by Full Name (Contains)
                    System.out.print("Enter Name fragment to search for: ");
                    searchTerm = scanner.nextLine().trim().toLowerCase();
                    if (searchTerm.isEmpty()) {
                        System.out.println("Search term cannot be empty.");
                        return;
                    }
                    for (Infor student : studentList) {
                        if (student.getFullName().toLowerCase().contains(searchTerm)) {
                            searchResults.add(student);
                        }
                    }
                    break;

                case 3: // Search by Age
                    System.out.print("Enter Age to search for: ");
                    int searchAge = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    for (Infor student : studentList) {
                        if (student.getAge() == searchAge) {
                            searchResults.add(student);
                        }
                    }
                    break;

                case 4: // Search by GPA
                    System.out.print("Enter GPA to search for (e.g., 3.5): ");
                    float searchGpa = scanner.nextFloat();
                    scanner.nextLine(); // Consume newline
                    // Be cautious with float comparisons due to precision issues
                    // A range search might be better in a real application
                    for (Infor student : studentList) {
                        if (Math.abs(student.getGpa() - searchGpa) < 0.001) { // Check for near equality
                            searchResults.add(student);
                        }
                    }
                    break;

                default:
                    // Should not happen due to validation in selectSearchOption
                    System.out.println("Invalid search type.");
                    return;
            }

            // Display results
            if (searchResults.isEmpty()) {
                System.out.println("No students found matching the criteria.");
            } else {
                System.out.println("\n--- Search Results ---");
                studentViewer.displayStudentList(searchResults);
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input type for search value.");
            // Consume potentially leftover invalid input
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }
    }
}