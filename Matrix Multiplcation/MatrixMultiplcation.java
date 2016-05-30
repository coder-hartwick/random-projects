import java.util.Scanner;
import java.util.Arrays;

/******************************************************************************
 * MatrixMultiplcation.java
 * Author: Jordan Hartwick
 * Usage: java MatrixMultiplcation
 * Created on: Saturday May 28, 2016 @ 1:13 AM
 * 
 * Purpose: Multiplies two matricies and displays their product. 
 *
 * Practice Run:
 * Enter dimensions of first matrix: 2 3 
 * Enter your first matrix: 1 2 3 4 5 6
 * [1, 2, 3]
 * [4, 5, 6]
 * Enter dimensions of second matrix: 3 2
 * Enter your second matrix: 7 8 9 10 11 12
 * [7, 8]
 * [9, 10]
 * [11, 12]
 * Answer:
 * [58, 64]
 * [139, 154]
 */
public class MatrixMultiplcation {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		// Get the first matrix dimensions and the first matrix.
		System.out.print("Enter dimensions of first matrix: ");
		int[] dims1 = new int[2];
		dims1[0] = in.nextInt();
		dims1[1] = in.nextInt();
		System.out.print("Enter your first matrix: ");
		int[][] matrix1 = new int[dims1[0]][dims1[1]];

		for(int i = 0; i < matrix1.length; i++) {
			for(int j = 0; j < matrix1[i].length; j++) {
				matrix1[i][j] = in.nextInt();
			}
			System.out.println(Arrays.toString(matrix1[i]));
		}

		// Get the second matrix dimensions and the second matrix.		
		System.out.print("Enter dimensions of second matrix: ");
		int[] dims2 = new int[2];
		dims2[0] = in.nextInt();
		dims2[1] = in.nextInt();
		
		// Check dimensions for a mismatch; in (r1xc1) * (r2xc2), c1 must = r2.
		if(dims1[1] != dims2[0]) {
			System.out.println("Dimension Mismatch.");
			System.exit(0);
		}
		System.out.print("Enter your second matrix: ");
		int[][] matrix2 = new int[dims2[0]][dims2[1]];
		for(int i = 0; i < matrix2.length; i++) {
			for(int j = 0; j < matrix2[i].length; j++) {
				matrix2[i][j] = in.nextInt();
			}
			System.out.println(Arrays.toString(matrix2[i]));
		}
		
		System.out.println("Answer:");
		
		int[][] productMatrix = new int[dims1[0]][dims2[1]];
		
		// Calculate the matrix. Multiply the current position in the current 
		// row by the current position in the current column and add it to the
		// current (row,col) position in the product matrix.
		for(int r = 0; r < dims1[0]; r++) {
			for(int c = 0; c < dims2[1]; c++) {
				for(int i = 0; i < matrix1[r].length; i++) {
					productMatrix[r][c] += (matrix1[r][i] * matrix2[i][c]);
				}			
			}
			System.out.println(Arrays.toString(productMatrix[r]));
		}
	}
}
