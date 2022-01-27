package xairaven;

public class MatrixTest {
    public static void main() {
        double[] X = {5, 6, 7};
        double[] Y = {1, 2, 3};
        System.out.printf("Inner product of X(5, 6, 7) and Y(1, 2, 3) is %.0f\n", Matrix.dot(X, Y));
        double[][] A = {
                {1, 3, 2},
                {3, 4, 4},
                {5, 6, 7},
        };
        double[][] B = {
                {2, 2},
                {3, 4},
                {5, 6}
        };
        double[][] resultMatrixMultiplication = Matrix.mult(A, B);
        System.out.println("Result of multiplication A and B is:");
        for (int i = 0; i < resultMatrixMultiplication.length; i++) {
            for (int j = 0; j < resultMatrixMultiplication[0].length; j++) {
                System.out.printf("%.1f\t", resultMatrixMultiplication[i][j]);
            }
            System.out.println();
        }
        System.out.println("Transposed matrix B:");
        double[][] transposedMatrix = Matrix.transpose(B);
        for (int i = 0; i < transposedMatrix.length; i++) {
            for (int j = 0; j < transposedMatrix[0].length; j++) {
                System.out.printf("%.1f\t", transposedMatrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("Result of multiplication A and X is:");
        double[] AX = Matrix.mult(A, X);
        for (int i = 0; i < AX.length; i++) {
            System.out.printf("%.1f\t", AX[i]);
        }
        System.out.println("\nResult of multiplication Y and B is:");
        double[] YB = Matrix.mult(Y, B);
        for (int i = 0; i < YB.length; i++) {
            System.out.printf("%.1f\t", YB[i]);
        }
        System.out.print("\n");
    }
}
