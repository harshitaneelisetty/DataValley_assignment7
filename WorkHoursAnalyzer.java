import java.util.*;

public class EmployeeWorkHoursAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        int numberOfEmployees = sc.nextInt();

        List<List<Integer>> workHoursList = new ArrayList<>();

        for (int i = 1; i <= numberOfEmployees; i++) {
            System.out.println("For Employee " + i + ":");
            List<Integer> workHoursPerDay = new ArrayList<>();
            for (int j = 1; j <= 7; j++) {
                System.out.print("Enter work hours for Day " + j + ": ");
                int hours = sc.nextInt();
                workHoursPerDay.add(hours);
            }
            workHoursList.add(workHoursPerDay);
        }

        int moreThan40 = 0, exactly40 = 0, lessThan40 = 0;
        double moreThan40Avg = 0, exactly40Avg = 0, lessThan40Avg = 0;

        for (List<Integer> workHoursPerEmployee : workHoursList) {
            int totalHours = workHoursPerEmployee.stream().mapToInt(Integer::intValue).sum();
            double avgHours = totalHours / 7.0;

            if (totalHours > 40) {
                moreThan40++;
                moreThan40Avg += avgHours;
            } else if (totalHours == 40) {
                exactly40++;
                exactly40Avg += avgHours;
            } else {
                lessThan40++;
                lessThan40Avg += avgHours;
            }
        }

        moreThan40Avg /= moreThan40 > 0 ? moreThan40 : 1;
        exactly40Avg /= exactly40 > 0 ? exactly40 : 1;
        lessThan40Avg /= lessThan40 > 0 ? lessThan40 : 1;

        System.out.println("\nWork hours analysis:");
        System.out.println("More than 40 hours:");
        System.out.println("  Number of employees: " + moreThan40);
        System.out.println("  Average hours worked per day: " + moreThan40Avg);
        System.out.println("Exactly 40 hours:");
        System.out.println("  Number of employees: " + exactly40);
        System.out.println("  Average hours worked per day: " + exactly40Avg);
        System.out.println("Less than 40 hours:");
        System.out.println("  Number of employees: " + lessThan40);
        System.out.println("  Average hours worked per day: " + lessThan40Avg);
    }
}
