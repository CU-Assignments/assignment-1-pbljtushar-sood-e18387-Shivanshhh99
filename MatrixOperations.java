import java.util.Scanner;

public class MatrixOperations {

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rowsMatrix1 = matrix1.length;
        int colsMatrix1 = matrix1[0].length;
        int rowsMatrix2 = matrix2.length;
        int colsMatrix2 = matrix2[0].length;

        if (colsMatrix1 != rowsMatrix2) {
            throw new IllegalArgumentException("Matrix multiplication is not possible: number of columns in Matrix 1 must equal number of rows in Matrix 2.");
        }

        int[][] result = new int[rowsMatrix1][colsMatrix2];

        for (int i = 0; i < rowsMatrix1; i++) {
            for (int j = 0; j < colsMatrix2; j++) {
                for (int k = 0; k < colsMatrix1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows and columns for Matrix 1:");
        int rows1 = scanner.nextInt();
        int cols1 = scanner.nextInt();

        System.out.println("Enter the number of rows and columns for Matrix 2:");
        int rows2 = scanner.nextInt();
        int cols2 = scanner.nextInt();

        if (rows1 != rows2 || cols1 != cols2) {
            System.out.println("Matrix dimensions do not match for addition and subtraction.");
            return;
        }
        if (cols1 != rows2) {
            System.out.println("Matrix dimensions do not match for multiplication.");
            return;
        }

        int[][] matrix1 = new int[rows1][cols1];
        int[][] matrix2 = new int[rows2][cols2];

        System.out.println("Enter the elements of Matrix 1:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the elements of Matrix 2:");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        System.out.println("\nAddition:");
        int[][] sum = addMatrices(matrix1, matrix2);
        printMatrix(sum);

        System.out.println("\nSubtraction:");
        int[][] difference = subtractMatrices(matrix1, matrix2);
        printMatrix(difference);

        System.out.println("\nMultiplication:");
        int[][] product = multiplyMatrices(matrix1, matrix2);
        printMatrix(product);

        scanner.close();
    }
}
