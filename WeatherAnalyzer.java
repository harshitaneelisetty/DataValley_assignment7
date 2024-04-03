import java.util.*;

public class WeatherAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of days: ");
        int numberOfDays = sc.nextInt();

        List<Double> temperatures = new ArrayList<>();
        List<Double> humidities = new ArrayList<>();

        for (int i = 1; i <= numberOfDays; i++) {
            System.out.println("Day " + i + ":");
            System.out.print("  Temperature (in Celsius): ");
            double temperature = sc.nextDouble();
            temperatures.add(temperature);

            System.out.print("  Humidity (in percentage): ");
            double humidity = sc.nextDouble();
            humidities.add(humidity);
        }

        double[] temperatureRanges = {-Double.MAX_VALUE, 0, 10, 20, 30, 40}; 
        String[] rangeLabels = {"<0°C", "0-10°C", "10-20°C", "20-30°C", "30-40°C", ">40°C"};

        int[] counts = new int[temperatureRanges.length];
        double[] totalHumidities = new double[temperatureRanges.length];

        for (int i = 0; i < numberOfDays; i++) {
            double temperature = temperatures.get(i);
            double humidity = humidities.get(i);

            int rangeIndex = findRangeIndex(temperature, temperatureRanges);
            counts[rangeIndex]++;
            totalHumidities[rangeIndex] += humidity;
        }

        double[] averageHumidities = new double[temperatureRanges.length];
        for (int i = 0; i < temperatureRanges.length; i++) {
            if (counts[i] != 0) {
                averageHumidities[i] = totalHumidities[i] / counts[i];
            }
        }

        System.out.println("Weather data summary:");
        for (int i = 0; i < temperatureRanges.length - 1; i++) {
            System.out.println(rangeLabels[i] + ":");
            System.out.println("   Number of days with temperature in this range: " + counts[i]);
            System.out.println("   Average humidity: " + averageHumidities[i] + "%");
        }
        System.out.println(rangeLabels[temperatureRanges.length - 1] + " and above:");
        System.out.println("   Number of days with temperature in this range: " + counts[temperatureRanges.length - 1]);
    }

    private static int findRangeIndex(double temperature, double[] temperatureRanges) {
        for (int i = 0; i < temperatureRanges.length; i++) {
            if (temperature < temperatureRanges[i]) {
                return i;
            }
        }
        return temperatureRanges.length - 1; 
    }
}
