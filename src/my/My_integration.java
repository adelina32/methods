package my;

public class My_integration {

    public static double f1(double x) {
        return Math.pow(x, 4);
    }

    public static double f2(double x) {
        return Math.cos(x);
    }

    public static void main(String[] args) {
        // точки в которых вычисляется значение функции
        double[] nodes = {0.41577, 2.29428, 6.28995};
        double[] weights = {0.71109, 0.27852, 0.01039};

        // Вычисление интеграла для f(x) = x^4
        double integralX4 = 0;
        for (int i = 0; i < nodes.length; i++) {
            System.out.println(f1(nodes[i]));
            integralX4 += weights[i] * f1(nodes[i]); //0.71109⋅f(0.41577)+0.27852⋅f(2.29428)+0.01039⋅f(6.28995)
        }
        System.out.printf("Приближенное значение для f(x) = x^4: %.8f\n", integralX4);
        System.out.print("Точное значение для f(x) = x^4: 24.0\n");
        System.out.printf("Разница: %.8f\n", Math.abs(integralX4 - 24.0));

        // Вычисление интеграла для f(x) = cos(x)
        double integralCos = 0;
        for (int i = 0; i < nodes.length; i++) {
            System.out.println(f2(nodes[i]));
            integralCos += weights[i] * f2(nodes[i]);
        }
        System.out.printf("Приближенное значение для f(x) = cos(x): %.8f\n", integralCos);
        System.out.print("Точное значение для f(x) = cos(x): 0.5\n");
        System.out.printf("Разница: %.8f\n", Math.abs(integralCos - 0.5));
    }
}
