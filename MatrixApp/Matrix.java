import java.io.*;
import java.util.*;

public class Matrix {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
    

        String matrixFile1 = "matrix1.txt";
        String matrixFile2 = "matrix2.txt";

        try {
            if (new File(matrixFile1).exists() && new File(matrixFile2).exists()) {

            int[][] matrix1 = readMatrixFromFile(matrixFile1);
            int[][] matrix2 = readMatrixFromFile(matrixFile2);

            if (matrix1[0].length != matrix2.length) {
                System.out.println("Cannot Multiply! Need equal number of columns in matrix 1 as the number of rows in matrix 2");
                return;
            }
        

            //multiply the matrices
            int[][] resultMatrix = multiplyMatrices(matrix1, matrix2);

            //result matrix
            writeMatrixToFile("matrix3.txt", resultMatrix);

            System.out.println("Matrices have been multiplied and result is save in 'matrix3.txt'");
        
        } else {
            System.out.print("Enter the size of the square matrices (n x n):");
            int size = scanner.nextInt();

            //generating two random square matrices
            int[][] matrix1 = generateRandomMatrix(size);
            int[][] matrix2 = generateRandomMatrix(size);

            writeMatrixToFile("matrix1.txt", matrix1);
            writeMatrixToFile("matrix2.txt", matrix2);

            int[][] resultMatrix = multiplyMatrices(matrix1, matrix2);

            writeMatrixToFile("matrix3.txt", resultMatrix);

            System.out.println("Random matrices were generated and multiplied, result saved as 'matrix3.txt'");
        }

    } finally {
        scanner.close();
    }
}

    public static int[][] readMatrixFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        ArrayList<int[]> matrixList = new ArrayList<>();
        String line;

        while ((line = reader.readLine()) != null) {
            String[] values = line.split("\\s+");
            int[] row = new int [values.length];
            for (int i =0; i < values.length; i++) {
                row [i] = Integer.parseInt(values[i]);
            }
            matrixList.add(row);
        }

    reader.close();

    //make list into a 2d array
    int[][] matrix = new int[matrixList.size()][];
    for (int i = 0; i < matrixList.size(); i++) {
        matrix[i] = matrixList.get(i);
    }
    return matrix;
}

public static int[][] generateRandomMatrix(int size) {
    Random rando = new Random();
    int[][] matrix = new int[size][size];

    for (int i = 0; i < size; i++){
        for (int j = 0; j < size; j++) {
            matrix[i][j] = rando.nextInt(10); //generate random numb. between 0 and 9
        }
    }
    return matrix;
}
//this is a method for multiplying matrices
public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
    int rows1 = matrix1.length;
    int cols1 = matrix1[0].length;
    int cols2 = matrix2[0].length;

    int[][] resultMatrix = new int[rows1][cols2];

    for (int i = 0; i < rows1; i++) {
        for (int j = 0; j < cols2; j++) {
            resultMatrix[i][j] = 0;
            for (int k = 0; k < cols1; k++) {
                resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
            }
        }
    }
    return resultMatrix;
}

//this method writes the matrix to a file
public static void writeMatrixToFile(String fileName, int[][] matrix) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            writer.write(matrix[i][j] + " ");
        }
        writer.newLine();
    }
    writer.close();
}

}