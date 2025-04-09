package menu;

import java.util.Scanner;

public class MenuEdit {

    public class editStudent {

        Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                MainMenuEdit();
                int choice = Select(scanner);

                if (choice == 0) {
                    System.out.println("Thoat app.");
                    scanner.close();
                    return;
                }
            }
        }

        private static void MainMenuEdit() {
            System.out.println("\n--- Menu ---");
            System.out.println("[1] - FullName");
            System.out.println("[2] - Age");
            System.out.println("[3] - GPA");
            System.out.println("[4] - Save");
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

}
