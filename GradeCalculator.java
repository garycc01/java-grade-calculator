import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("== STUDENT GRADE CALCULATOR ==");

        System.out.print("Enter the first grade: ");
        double grade1 = scanner.nextDouble();

        System.out.print("Enter the second grade: ");
        double grade2 = scanner.nextDouble();

        System.out.print("Enter the third grade: ");
        double grade3 = scanner.nextDouble();

        double average = (grade1 + grade2 + grade3) / 3;

        System.out.println("\nStudent average: " + average);

        if (average >= 5) {
            System.out.println("Result: PASSED");
        } else {
            System.out.println("Result: FAILED");
        }

        scanner.close();
    }
}