package Book.Part1;
import java.util.HashSet;

public class ZeroMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{-2, 9, 15, 6, -7, 6, 9}, {11, 3, 1, 8, -15, -1, 6}, {8, 8, 8, 8, 8, 8, 8},
                {3, 0, 14, 7, 9, 11, 6}, {0, 78, -9, 45, -3, 54, 4}, {1, 0, 8, 9, -6, 1, 15}, {71, 87, -32, 2, 22, 42, 16}};
        printMatrix(matrix);
        System.out.println("#########################################################");
        matrix = zeroColRow(matrix);
        printMatrix(matrix);
    }

    private static int[][] zeroColRow(int[][] matrix) {
        int i, j;
        HashSet<Integer> setRow = new HashSet<>();
        HashSet<Integer> setCol = new HashSet<>();
        for (i = 0; i < matrix.length; i++) {
            for (j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    setRow.add(i);
                    setCol.add(j);
                }
            }
        }
        for (int row : setRow) {
            for (int c = 0; c < matrix[row].length; c++) {
                matrix[row][c] = 0;
            }
        }
        for (int col : setCol) {
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][col] = 0;
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][]matrix) {
        int i, j;
        for (i = 0; i < matrix.length; i++) {
            for (j = 0; j < matrix[i].length-1; j++) {
                System.out.printf("%d\t", matrix[i][j]);
            }
            System.out.println(matrix[i][j]);
        }
    }
}
