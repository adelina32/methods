package my;

public class Slay_1 {

    public static void main(String[] args) {
        double[][] matrix = {
                {2, 3, 1, 5},
                {4, 1, 2, 6},
                {1, 2, 3, 7}
        };

        int n = matrix.length;
        printMatrix(matrix);
        double[] solution = gaussianElimination(matrix, n);
        System.out.println("Решение: ");
        for (int i = 0; i < n; i++) {
            System.out.printf("x[%d] = %.2f\n", i, solution[i]);
        }
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%.2f ", value);
            }
            System.out.println();
        }
    }

    public static double[] gaussianElimination(double[][] matrix, int n) {
        // Прямой ход
        for (int i = 0; i < n; i++) {
            // Поиск главного элемента
            int maxRow = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(matrix[k][i]) > Math.abs(matrix[maxRow][i])) {
                    maxRow = k;
                }
            }
            // Обмен строк
            double[] temp = matrix[i];
            matrix[i] = matrix[maxRow];
            matrix[maxRow] = temp;

            // Приведение к треугольному виду
            for (int k = i + 1; k < n; k++) {
                double factor = matrix[k][i] / matrix[i][i]; // Множитель строки вычисляем
                for (int j = i; j < n + 1; j++) {
                    matrix[k][j] -= factor * matrix[i][j];
                }
            }
        }

        // Обратный ход
        double[] solution = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            solution[i] = matrix[i][n]; // Начинаем с свободного члена
            for (int j = i + 1; j < n; j++) {
                solution[i] -= matrix[i][j] * solution[j]; // Вычитаем произведения
            }
            solution[i] /= matrix[i][i]; // Делим на коэффициент перед переменной
        }

        return solution;
    }
}
