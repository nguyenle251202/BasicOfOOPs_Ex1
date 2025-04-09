package menu;

import java.util.Scanner;

public class MenuSearch {

        Scanner scanner = new Scanner(System.in);

        public static void searchStudent(String[] args) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                MainMenuSearch();
                int choice = Select(scanner);

                if (choice == 0) {
                    System.out.println("Thoat app.");
                    scanner.close();
                    return;
                }
            }
        }

        private static void MainMenuSearch() {
            System.out.println("\n--- Menu ---");
            System.out.println("[2] - id");
            System.out.println("[3] - FullName");
            System.out.println("[4] - Age");
            System.out.println("[5] - GPA");
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

