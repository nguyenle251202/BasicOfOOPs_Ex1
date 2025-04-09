package infor;

import java.util.ArrayList;
import java.util.List;

public class View {

    public void displayStudentList(List<Infor> studentList) {
        if (studentList == null || studentList.isEmpty()) {
            System.out.println("No student data to display.");
            return;
        }

        int idWidth = 8;
        int nameWidth = 25;
        int ageWidth = 5;
        int gpaWidth = 6;

        String headerFormat = "| %-" + idWidth + "s | %-" + nameWidth + "s | %" + ageWidth + "s | %" + gpaWidth + "s |%n";
        String rowFormat = "| %-" + idWidth + "s | %-" + nameWidth + "s | %" + ageWidth + "d | %" + gpaWidth + ".2f |%n";
        String separator = "+" + "-".repeat(idWidth + 2) + "+" + "-".repeat(nameWidth + 2) + "+" + "-".repeat(ageWidth + 2) + "+" + "-".repeat(gpaWidth + 2) + "+%n";

        System.out.format(separator);
        System.out.format(headerFormat, "ID", "Full Name", "Age", "GPA");
        System.out.format(separator);

        for (Infor student : studentList) {
            System.out.format(rowFormat,
                    student.getId(),
                    student.getFullName(),
                    student.getAge(),
                    student.getGpa());
        }

        System.out.format(separator);
    }

    public static void main(String[] args) {
        List<Infor> students = new ArrayList<>();
        students.add(new Infor(null, "Nguyen Van A", 20, 3.85f));
        students.add(new Infor(null, "Tran Van B", 22, 3.20f));
        students.add(new Infor(null, "Ly thi C", 19, 3.95f));
        students.add(new Infor(null, "Le Van D", 21, 3.50f));
        students.add(new Infor(null, "Duong Van E", 20, 3.11f));


        View studentView = new View();

        System.out.println("--- Student List ---");
        studentView.displayStudentList(students);
    }
}