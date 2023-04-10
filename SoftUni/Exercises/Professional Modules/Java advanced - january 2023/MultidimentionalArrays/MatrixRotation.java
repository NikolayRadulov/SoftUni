package multyDimentionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String rotateString = sc.nextLine();
        int angleRotation = (Integer.parseInt(rotateString.split("[()]+")[1]) % 360)/90;
        String input = sc.nextLine();
        List<String> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        while (!input.equals("END")) {
            list.add(input);
            if(input.length() > max) {
            	max = input.length();
            }
            input = sc.nextLine();
        }
        char[][] matrix = new char[list.size()][];

        for (int i = 0; i < list.size(); i++) {
            char[] maxWord = new char[max];
            char[] word = list.get(i).toCharArray();
            for (int j = 0; j < maxWord.length; j++) {
                if(j < word.length)maxWord[j] = word[j];
                else maxWord[j] = ' ';
            }
            matrix[i] = maxWord;
        }

        for(int i = 1; i <= angleRotation; i++) {
            matrix = rotate(matrix);
        }
        printMatrix(matrix);
        sc.close();
    }

    public static char[][] rotate(char[][] matrix){
        char[][] rotatedMatrix = new char[matrix[0].length][matrix.length];
        int col = 0;
        for(int i = matrix.length-1; i >= 0; i--) {
            for(int j = 0; j < matrix[0].length; j++) {
                rotatedMatrix[j][col] = matrix[i][j];
            }
            col++;
        }
        return rotatedMatrix;
    }
    
  private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
               System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}