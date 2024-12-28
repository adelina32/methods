package my;

import java.util.function.Function;

public class My_integration1 {

    public static double f1(double x) {
        return Math.pow(x, 4);
    }

    public static double f2(double x) {
        return Math.cos(x);
    }

    // Вторая производная f(x) = x^4
    public static double f1SecondPrime(double x) {
        return 4 * 3 * Math.pow(x, 2);
    }

    // Вторая производная f(x) = cos(x)
    public static double f2SecondPrime(double x) {
        return -Math.cos(x);
    }

    public static void main(String[] args) {
        // Узлы и веса для n = 3 (точки в которых вычисляется значение функции)
        double[] nodes = {0.41577, 2.29428, 6.28995};
        double[] weights = {0.71109, 0.27852, 0.01039};

        // Вычисление интеграла для f(x) = x^4
        double integralX4 = 0;
        for (int i = 0; i < nodes.length; i++) {
            integralX4 += weights[i] * f1(nodes[i]); //0.71109⋅f(0.41577)+0.27852⋅f(2.29428)+0.01039⋅f(6.28995)
        }
        System.out.printf("Приближенное значение для f(x) = x^4: %.8f", integralX4);
        System.out.print("Точное значение для f(x) = x^4: 24.0");
        System.out.printf("Разница: %.8f", Math.abs(integralX4 - 24.0));

        // Вычисление интеграла для f(x) = cos(x)
        double integralCos = 0;
        for (int i = 0; i < nodes.length; i++) {
            integralCos += weights[i] * f2(nodes[i]); //0.71109⋅f(0.41577)+0.27852⋅f(2.29428)+0.01039⋅f(6.28995)
        }
        System.out.printf("Приближенное значение для f(x) = cos(x): %.8f", integralCos);
        System.out.print("Точное значение для f(x) = cos(x): 0.5");
        System.out.printf("Разница: %.8f", Math.abs(integralCos - 0.5));

        // Оценка ошибки для f(x) = x^4
        double M2nX4 = findMaxSecondDerivative(My_integration1::f1SecondPrime, 0.0, 10.0); // Оценка на интервале [0, 10]
        double errorBoundX4 = (factorial(3) * factorial(3)) / factorial(6) * M2nX4;
        System.out.printf("Оценка ошибки для f(x) = x^4: %.8f\n", errorBoundX4);

        // Оценка ошибки для f(x) = cos(x)
        double M2nCos = findMaxSecondDerivative(My_integration1::f2SecondPrime, 0.0, 10.0); // Оценка на интервале [0, 10]
        double errorBoundCos = (factorial(3) * factorial(3)) / factorial(6) * M2nCos;
        System.out.printf("Оценка ошибки для f(x) = cos(x): %.8f\n", errorBoundCos);
    }

    // Факториал
    public static double factorial(int n) {
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Функция для нахождения максимума второй производной на заданном интервале
    public static double findMaxSecondDerivative(Function<Double, Double> secondDerivative, double start, double end) {
        double max = 0;
        for (double x = start; x <= end; x += 0.01) { // Шаг 0.01 для более точного поиска
            double value = secondDerivative.apply(x);
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}