import java.util.Arrays;
import java.util.Scanner;


/*******************************************************************************
 * Created by: Jordan Hartwick
 * Date: May 29, 2016 @ 9:16 PM. 
 * Usage: java MatrixAddition
 *
 * Purpose: Adds two matricies together. 
 *
 * Test Run
 ****************************************
 * Type dimension of first matrix: 2 2
 * Type dimension of second matrix: 2 2
 * Type your first matrix: 3 8 4 6 
 * Type your second matrix: 4 0 1 -9
 * Calculating solution
 * [7, 8]
 * [5, -3]
 *
 */
public class MatrixAddition {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int[] dims1 = new int[2];
		System.out.print("Type dimension of first matrix: ");
		dims1[0] = in.nextInt();
		dims1[1] = in.nextInt();
		
		int[] dims2 = new int[2];
		System.out.print("Type dimension of second matrix: ");
		if(in.nextInt() != dims1[0]) {
			System.out.println("Dimension Mismatch!");
			System.exit(0);
		} else if(in.nextInt() != dims1[1]) {
			System.out.println("Dimension Mismatch!");
			System.exit(0);			
		}
		
		
		int[][] matrix1 = new int[dims1[0]][dims1[1]];
		System.out.print("Type your first matrix: ");
		for(int r = 0; r < dims1[0]; r++) {
			for(int c = 0; c < dims1[1]; c++) {
				matrix1[r][c] = in.nextInt();
			}
		}
		
		
		int[][] matrix2 = new int[dims1[0]][dims1[1]];
		System.out.print("Type your second matrix: ");
		for(int r = 0; r < dims1[0]; r++) {
			for(int c = 0; c < dims1[1]; c++) {
				matrix2[r][c] = in.nextInt();
			}
		}
		
				
		System.out.println("Calculating solution");
		int[][] solution = new int[dims1[0]][dims1[1]];
		
		for(int r = 0; r < dims1[0]; r++) {
			for(int c = 0; c < dims1[1]; c++) {
				solution[r][c] = matrix1[r][c] + matrix2[r][c];
			}
			System.out.println(Arrays.toString(solution[r]));
		}
	}
}
