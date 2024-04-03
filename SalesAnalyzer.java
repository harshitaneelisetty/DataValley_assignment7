import java.util.*;

public class SalesAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of product sales: ");
        int numberOfSales = sc.nextInt();

        List<Double> productPrices = new ArrayList<>();

        for (int i = 0; i < numberOfSales; i++) {
            System.out.print("Enter the price for product " + (i + 1) + ": $");
            double price = sc.nextDouble();
            productPrices.add(price);
        }

        double[] priceRanges = {50, 100, 200, 300, 400, 500}; 
        String[] rangeLabels = {"$0-50", "$50-100", "$100-200", "$200-300", "$300-400", "$400-500", "Over $500"};

        int[] counts = new int[priceRanges.length + 1];
        double[] revenues = new double[priceRanges.length + 1];

        for (double price : productPrices) {
            int rangeIndex = findRangeIndex(price, priceRanges);
            counts[rangeIndex]++;
            revenues[rangeIndex] += price;
        }

        System.out.println("Product sales summary:");
        for (int i = 0; i < priceRanges.length; i++) {
            System.out.println(rangeLabels[i] + ":");
            System.out.println("   Number of products sold: " + counts[i]);
            System.out.println("   Total revenue generated: $" + revenues[i]);
        }

        System.out.println(rangeLabels[priceRanges.length] + ":");
        System.out.println("   Number of products sold: " + counts[priceRanges.length]);
        System.out.println("   Total revenue generated: $" + revenues[priceRanges.length]);
    }

    private static int findRangeIndex(double price, double[] priceRanges) {
        for (int i = 0; i < priceRanges.length; i++) {
            if (price <= priceRanges[i]) {
                return i;
            }
        }
        return priceRanges.length; 
    }
}
