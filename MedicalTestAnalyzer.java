import java.util.*;

public class MedicalTestAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of patients: ");
        int numberOfPatients = sc.nextInt();

        List<Double> testResults = new ArrayList<>();

        for (int i = 1; i <= numberOfPatients; i++) {
            System.out.print("Enter the test result for patient " + i + ": ");
            double result = sc.nextDouble();
            testResults.add(result);
        }

        double[] rangeValues = {0, 10, 20, 30}; 
        String[] rangeLabels = {"Normal", "Borderline", "High", "Very High"};

        int[] counts = new int[rangeValues.length];
        double[] totalValues = new double[rangeValues.length];

        for (double result : testResults) {
            int rangeIndex = findRangeIndex(result, rangeValues);
            counts[rangeIndex]++;
            totalValues[rangeIndex] += result;
        }

        double[] averageValues = new double[rangeValues.length];
        for (int i = 0; i < rangeValues.length; i++) {
            if (counts[i] != 0) {
                averageValues[i] = totalValues[i] / counts[i];
            }
        }

        System.out.println("Medical test results summary:");
        for (int i = 0; i < rangeValues.length - 1; i++) {
            System.out.println(rangeLabels[i] + ":");
            System.out.println("   Number of patients: " + counts[i]);
            System.out.println("   Average value: " + averageValues[i]);
        }
        System.out.println(rangeLabels[rangeValues.length - 1] + " and above:");
        System.out.println("   Number of patients: " + counts[rangeValues.length - 1]);
    }

    private static int findRangeIndex(double value, double[] rangeValues) {
        for (int i = 0; i < rangeValues.length; i++) {
            if (value < rangeValues[i]) {
                return i;
            }
        }
        return rangeValues.length - 1; 
    }
}
