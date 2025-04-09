package menu;

import infor.Infor;
import infor.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class MainMenu {

    private static List<Infor> studentList = View.getInitialStudentData();
    private static View studentView = new View();

    public static void mainMenu(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = selectChoice(scanner);

            if (choice == 0) {
                System.out.println("Thoat app.");
                scanner.close();
                break;
            }

            processChoice(choice, scanner);
        }
        System.out.println("Application finished.");
    }

    private static void displayMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("[1] - Add Student");
        System.out.println("[2] - Edit Student");
        System.out.println("[3] - Delete Student");
        System.out.println("[4] - View/Sort Student List");
        System.out.println("[5] - Search Student");
        System.out.println("[0] - Exit Application");
        System.out.print("Chon chuc nang: ");
    }

    private static int selectChoice(Scanner scanner) {
        int choice = -1;
        while (true) {
            // System.out.print("Nhap lua chon cua ban: "); // Prompt is now part of displayMenu
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();

                if (choice >= 0 && choice <= 5) {
                    return choice;
                } else {
                    System.out.println("Lua chon khong hop le. Vui long chon tu 0 den 5.");
                    System.out.print("Chon chuc nang: "); // Re-prompt
                }
            } else {
                System.out.println("Nhap sai dinh dang. Vui long nhap mot so.");
                scanner.next();
                scanner.nextLine();
                System.out.print("Chon chuc nang: "); // Re-prompt
            }
        }
    }

    private static void processChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                //System.out.println("\n--- Add New Student ---");
                MenuAdd.addStudent(scanner, studentList);
                break;
            case 2:
                //System.out.println("\n--- Edit Student Information ---");
                MenuEdit.editStudent(scanner, studentList);
                break;
            case 3:
                // System.out.println("\n--- Delete Student ---");
                deleteStudentById(scanner, studentList);
                break;
            case 4:
                // System.out.println("\n--- Danh Sach Sinh Vien ---");
                MenuView.showSortAndViewMenu(scanner, studentList, studentView);
                break;
            case 5:
                MenuSearch.showSearchMenu(scanner, studentList, studentView);
                break;
            default:
                System.out.println("Lua chon khong hop le.");
                break;
        }

        if (choice != 4 && choice != 0) {
            System.out.println("\nNhan Enter de quay lai menu...");
            scanner.nextLine();
        }
    }

    private static void deleteStudentById(Scanner scanner, List<Infor> studentList) {
        System.out.println("\n--- Delete Student ---");
        if (studentList.isEmpty()) {
            System.out.println("No students available to delete.");
            return;
        }

        System.out.print("Enter the ID of the student to delete (e.g., SV001): ");
        String idToDelete = scanner.nextLine().trim().toUpperCase();

        boolean found = false;
        Iterator<Infor> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Infor student = iterator.next();
            if (student.getId().equalsIgnoreCase(idToDelete)) {
                System.out.println("Deleting student: " + student);
                iterator.remove(); // Safe removal using iterator
                found = true;
                System.out.println("Student deleted successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID '" + idToDelete + "' not found.");
        }
    }
}