package example;

import java.util.Random;
import java.util.Scanner;

public class Main{
    private static final int MAX_SIZE = 20;
    private static final int MIN_VALUE = -100;
    private static final int MAX_VALUE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Input the number of rows (not more than 20): ");
        int rows = validateInput(scanner);

        System.out.print("Input the number of columns (not more than 20): ");
        int cols = validateInput(scanner);


        System.out.print("Input '1' for manual fill in, '2' for random generated: ");
        int choice = scanner.nextInt();
        int[][] matrix;

        if (choice == 1) {
            matrix = fillMatrixManually(rows, cols, scanner);
        } else {
            matrix = fillMatrixRandomly(rows, cols);
        }


        printMatrix(matrix);


        int min = findMin(matrix);
        int max = findMax(matrix);
        double average = calculateAverage(matrix);

        System.out.println("Min value: " + min);
        System.out.println("Max value: " + max);
        System.out.println("Average: " + average);

        scanner.close();
    }


    private static int validateInput(Scanner scanner) {
        int value;
        do {
            value = scanner.nextInt();
            if (value < 1 || value > MAX_SIZE) {
                System.out.print("Invalid value! Input the number between 1 and 20: ");
            }
        } while (value < 1 || value > MAX_SIZE);
        return value;
    }


    private static int[][] fillMatrixManually(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        System.out.println("Input matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }


    private static int[][] fillMatrixRandomly(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
            }
        }
        return matrix;
    }


    private static void printMatrix(int[][] matrix) {
        System.out.println("Matrix:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%4d ", value);
            }
            System.out.println();
        }
    }


    private static int findMin(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            for (int value : row) {
                if (value < min) {
                    min = value;
                }
            }
        }
        return min;
    }

    private static int findMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            for (int value : row) {
                if (value > max) {
                    max = value;
                }
            }
        }
        return max;
    }


    private static double calculateAverage(int[][] matrix) {
        int sum = 0;
        int count = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                sum += value;
                count++;
            }
        }
        return (double) sum / count;
    }
}
