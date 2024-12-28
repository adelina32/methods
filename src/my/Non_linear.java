package my;

public class Non_linear {
    public static double function(double x) {
        return x - 3.0 * Math.pow(x, 3.0) + 10.0;
    }

    public static double bisection(double a, double b, double tolerance) {
        if (function(a) * function(b) >= 0.0) {
            return Double.NaN;
        }
        else
        {
            double c = a;

            while (b - a >= tolerance) {
                c = (a + b) / 2.0;
                System.out.printf("c = %.4f, f(c) = %.4f%n", c, function(c));
                if (function(c) == 0.0) {
                    break;
                }

                if (function(c) * function(a) < 0.0) {
                    b = c;
                } else {
                    a = c;
                }
            }

            return c;
        }
    }

    public static void main(String[] args) {
        double a = 1.0;
        double b = 3.0;
        double tolerance = 0.03;
        double res = bisection(a, b, tolerance);
        System.out.printf("Корень уравнения: %.4f%n", res);
    }
}