import java.util.*;

public class HousingAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of houses sold: ");
        int numberOfHouses = sc.nextInt();

        List<Double> prices = new ArrayList<>();
        List<Double> squareFootages = new ArrayList<>();

        for (int i = 1; i <= numberOfHouses; i++) {
            System.out.println("For House " + i + ":");
            System.out.print("Enter the price: $");
            double price = sc.nextDouble();
            prices.add(price);
            System.out.print("Enter the square footage: ");
            double squareFootage = sc.nextDouble();
            squareFootages.add(squareFootage);
        }

        double[] priceRanges = {100000, 200000, 300000, 400000}; 
        String[] rangeLabels = {"$0-100,000", "$100,000-200,000", "$200,000-300,000", "$300,000-400,000", "Over $400,000"};

        int[] counts = new int[priceRanges.length + 1];
        double[] totalSquareFootages = new double[priceRanges.length + 1];

        for (int i = 0; i < numberOfHouses; i++) {
            double price = prices.get(i);
            double squareFootage = squareFootages.get(i);

            int rangeIndex = findRangeIndex(price, priceRanges);
            counts[rangeIndex]++;
            totalSquareFootages[rangeIndex] += squareFootage;
        }

        double[] averageSquareFootages = new double[priceRanges.length + 1];
        for (int i = 0; i < priceRanges.length; i++) {
            if (counts[i] != 0) {
                averageSquareFootages[i] = totalSquareFootages[i] / counts[i];
            }
        }

        System.out.println("Housing sales summary:");
        for (int i = 0; i < priceRanges.length; i++) {
            System.out.println(rangeLabels[i] + ":");
            System.out.println("   Number of houses sold: " + counts[i]);
            System.out.println("   Average square footage: " + averageSquareFootages[i]);
        }
        System.out.println(rangeLabels[priceRanges.length] + ":");
        System.out.println("   Number of houses sold: " + counts[priceRanges.length]);
    }

    private static int findRangeIndex(double price, double[] priceRanges) {
        for (int i = 0; i < priceRanges.length; i++) {
            if (price < priceRanges[i]) {
                return i;
            }
        }
        return priceRanges.length; 
    }
}
