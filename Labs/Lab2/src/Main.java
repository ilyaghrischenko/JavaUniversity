import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //1
        /*double[] aValues = {0.0, 0.5, 1.0, 1.5, 2.0};

        double xStart = 0.0;
        double xEnd = Math.PI;
        double dx = Math.PI / 36.0;

        System.out.printf("%-10s %-10s %-10s%n", "a", "x", "y(x)");

        for (double a : aValues) {
            for (double x = xStart; x <= xEnd; x += dx) {
                double y = Math.exp(-x * a) * Math.sin(x);
                System.out.printf("%-10.1f %-10.5f %-10.5f%n", a, x, y);
            }
        }*/

        //2
        /*Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть значення x (від -1 до 1): ");
        double x = scanner.nextDouble();

        if (x < -1 || x > 1) {
            System.out.println("Значення x повинно бути в діапазоні від -1 до 1.");
            return;
        }

        double epsilon = 1e-6;

        double sum = 0.0;
        double term = x;
        int n = 0;

        while (Math.abs(term) >= epsilon) {
            sum += term;
            n++;
            term *= (x * x * (2 * n - 1)) / (2 * n * (2 * n + 1));
        }

        System.out.printf("Наближене значення arcsin(%.5f) = %.6f%n", x, sum);*/

        //3
        /*double[] xValues = {0.5, Math.sqrt(2) / 2, -1};

        double epsilon = 1e-6;

        System.out.printf("%-15s %-15s %-15s %-15s%n", "x", "Approx S(x)", "Exact y(x)", "Difference");

        for (double x : xValues) {
            double sum = 0.0;
            double term = x;
            int n = 0;

            while (Math.abs(term) >= epsilon) {
                sum += term;
                n++;
                term *= (x * x * (2 * n - 1)) / (2 * n * (2 * n + 1));
            }

            double exact = Math.asin(x);

            double difference = Math.abs(sum - exact);

            System.out.printf("%-15.10f %-15.10f %-15.10f %-15.10f%n", x, sum, exact, difference);
        }*/

        //4
        double x0 = -1.5;
        double xk = -2.5;
        double dx = -0.5;
        double b = -0.8;

        for (double x = x0; x >= xk; x += dx) {
            double y = calculateFunction(x, b);
            System.out.printf("x = %.2f, y = %.4f%n", x, y);
        }
    }

    //4
    public static double calculateFunction(double x, double b) {
        return Math.pow(x, 2) + Math.tan(5 * x + b / x);
    }
}