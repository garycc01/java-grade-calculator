import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String continueAnswer = "yes";

        System.out.println("== STUDENT GRADE CALCULATOR ==");

        while (continueAnswer.equalsIgnoreCase("yes")) {

            // 🧹 Clean buffer BEFORE reading the name
            // 🧹 Limpiar buffer ANTES de leer el nombre
            scanner.nextLine();

            // 1. Student name
            System.out.print("Enter the student's name: ");
            String studentName = scanner.nextLine();

            // 2. Validate grades
            double grade1 = readGrade(scanner, "Enter the first grade: ");
            double grade2 = readGrade(scanner, "Enter the second grade: ");
            double grade3 = readGrade(scanner, "Enter the third grade: ");

            // 3. Highest / lowest
            double highest = Math.max(grade1, Math.max(grade2, grade3));
            double lowest  = Math.min(grade1, Math.min(grade2, grade3));

            double average = (grade1 + grade2 + grade3) / 3;

            // 4. Average with 2 decimals
            System.out.println("\n--- RESULTS FOR " + studentName.toUpperCase() + " ---");
            System.out.printf("Average: %.2f%n", average);
            System.out.printf("Highest grade: %.2f%n", highest);
            System.out.printf("Lowest grade: %.2f%n", lowest);

            if (average >= 5) {
                System.out.println("Result: PASSED");
            } else {
                System.out.println("Result: FAILED");
            }

            // 5. Multiple students
            System.out.print("\nCalculate another student? (yes/no): ");
            continueAnswer = scanner.nextLine().trim();

            System.out.println();
        }

        System.out.println("Goodbye!");
        scanner.close();
    }

    // Helper: read and validate a grade between 0 and 10
    private static double readGrade(Scanner scanner, String message) {
        double grade;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextDouble()) {
                grade = scanner.nextDouble();
                if (grade >= 0 && grade <= 10) {
                    // 🧹 Consume the newline left by nextDouble()
                    // 🧹 Consumir el salto de línea que deja nextDouble()
                    scanner.nextLine();
                    return grade;
                } else {
                    System.out.println("⚠ Grade must be between 0 and 10. Try again.");
                    scanner.nextLine();
                }
            } else {
                System.out.println("⚠ Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }
}