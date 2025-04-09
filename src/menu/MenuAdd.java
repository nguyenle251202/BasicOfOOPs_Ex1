package menu;

import java.util.Scanner;

public class MenuAdd {
    Scanner scanner = new Scanner(System.in);

    public static void addStudent(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            AddStudent();
            int choice = Select(scanner);

            if (choice == 0) {
                System.out.println("Thoat app.");
                scanner.close();
                return;
            }
//
//            if (choice == 5) {
//                xemHistory();
//                continue;
//            }
        }
    }

    private static void AddStudent() {
        System.out.println("\n--- Menu ---");
        System.out.println("[1] - Add");
        System.out.println("[2] - Edit");
        System.out.println("[3] - Delete");
        System.out.println("[4] - View");
        System.out.println("[5] - Search");
        System.out.println("[0] - Exit");
        System.out.print("Chon di: ");
    }
    private static int Select(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Nhap lai");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
