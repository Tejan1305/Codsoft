import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        int numSubjects = getNumberOfSubjects();
        int[] marks = getMarksForSubjects(numSubjects);
        int totalMarks = calculateTotalMarks(marks);
        double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);
        String grade = determineGrade(averagePercentage);
        displayResults(totalMarks, numSubjects, averagePercentage, grade);
    }

    public static int getNumberOfSubjects() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        return scanner.nextInt();
    }

    public static int[] getMarksForSubjects(int numSubjects) {
        Scanner scanner = new Scanner(System.in);
        int[] marks = new int[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.printf("Enter marks for subject %d (out of 100): ", i + 1);
            marks[i] = scanner.nextInt();
        }
        return marks;
    }

    public static int calculateTotalMarks(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    public static double calculateAveragePercentage(int totalMarks, int numSubjects) {
        return (double) totalMarks / (numSubjects * 100) * 100;
    }

    public static String determineGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A";
        } else if (averagePercentage >= 80) {
            return "B";
        } else if (averagePercentage >= 70) {
            return "C";
        } else if (averagePercentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void displayResults(int totalMarks, int numSubjects, double averagePercentage, String grade) {
        System.out.println("Total Marks: " + totalMarks + " / " + numSubjects * 100);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
    }
}
