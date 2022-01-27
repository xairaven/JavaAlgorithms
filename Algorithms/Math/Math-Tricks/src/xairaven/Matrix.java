package xairaven;

class Matrix {
    public static double dot(double[] x, double[] y) {
        if (x.length != y.length) return -1;
        double innerProduct = 0;
        for (int i = 0; i < x.length; i++) {
            innerProduct += x[i]*y[i];
        }
        return innerProduct;
    }

    public static double[][] mult(double[][] a, double[][] b) {
        if(a[0].length != b.length) return null;
        double[][] resultMatrix = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                double multiplication = 0;
                for (int k = 0; k < a[0].length; k++) {
                    multiplication += a[i][k] * b[k][j];
                }
                resultMatrix[i][j] = multiplication;
            }
        }
        return resultMatrix;
    }

    public static double[][] transpose(double[][] a) {
        double[][] transposeMatrix = new double[a[0].length][a.length];
        for(int i = 0; i < a[0].length; i++) {
            for(int j = 0; j < a.length; j++) {
                transposeMatrix[i][j] = a[j][i];
            }
        }
        return transposeMatrix;
    }

    public static double[] mult(double[][] a, double[] x) {
        if(a[0].length != x.length) return null;
        double[]resultMatrix = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < x.length; j++) {
                double multiplication = 0;
                for (int k = 0; k < a[0].length; k++) {
                    multiplication += a[i][k] * x[k];
                }
                resultMatrix[i] = multiplication;
            }
        }
        return resultMatrix;
    }

    public static double[] mult(double[] y, double[][] a) {
        if(y.length != a.length) return null;
        double[] resultMatrix = new double[a[0].length];
        for (int i = 0; i < y.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                double multiplication = 0;
                for (int k = 0; k < y.length; k++) {
                    multiplication += y[k] * a[k][j];
                }
                resultMatrix[j] = multiplication;
            }
        }
        return resultMatrix;
    }
}
