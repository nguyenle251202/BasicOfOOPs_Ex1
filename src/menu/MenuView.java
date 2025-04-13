package menu;

import infor.Infor;
import infor.View;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MenuView {

    public static void showSortAndViewMenu(Scanner scanner, List<Infor> originalStudentList, View studentViewer) {

        while (true) {
            displaySortOptions();
            int sortChoice = selectSortChoice(scanner);

            if (sortChoice == 0) {
                System.out.println("Returning to main menu.");
                return;
            }

            List<Infor> listToSort = new ArrayList<>(originalStudentList);

            switch (sortChoice) {
                case 1: // Sort by Full Name (A-Z)
                    // Use Comparator.comparing with a method reference
                    listToSort.sort(Comparator.comparing(Infor::getFullName, String.CASE_INSENSITIVE_ORDER));
                    System.out.println("\n--- Student List (Sorted by Name A-Z) ---");
                    studentViewer.displayStudentList(listToSort); // Display the sorted copy
                    break;
                case 2: // Sort by GPA (Low to High)
                    listToSort.sort(Comparator.comparing(Infor::getGpa));
                    System.out.println("\n--- Student List (Sorted by GPA Low-High) ---");
                    studentViewer.displayStudentList(listToSort); // Display the sorted copy
                    break;
                case 3: // Sort by ID
                    listToSort.sort(Comparator.comparing(Infor::getId));
                    System.out.println("\n--- Danh Sach Sinh Vien ---");
                    studentViewer.displayStudentList(listToSort);
                default:
                    System.out.println("Invalid sort option.");
                    break;
            }

            System.out.println("\nPress Enter to choose another sort option or exit...");
            scanner.nextLine();
        }
    }

    // Renamed for clarity
    private static void displaySortOptions() {
        System.out.println("\n--- View & Sort Options ---");
        System.out.println("[1] - Sort by Fullname (A -> Z)");
        System.out.println("[2] - Sort by GPA (Low -> High)");
        System.out.println("[3] - Sort by ID (Low -> High)");
        System.out.println("[0] - Back to Main Menu");
        System.out.print("Choose sort option: ");
    }

    // Renamed and improved input handling (similar to MainMenu's selectChoice)
    private static int selectSortChoice(Scanner scanner) {
        int choice = -1;
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the leftover newline

                if (choice >= 0 && choice <= 3) { // Valid range for this menu
                    return choice;
                } else {
                    System.out.println("Invalid choice. Please enter 0, 1, 2, or 3.");
                    System.out.print("Choose sort option: "); // Re-prompt
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume invalid input
                scanner.nextLine(); // Consume the rest of the line
                System.out.print("Choose sort option: "); // Re-prompt
            }
        }
    }
}