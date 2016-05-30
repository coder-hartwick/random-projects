import java.util.Arrays;
import java.util.Scanner;


/******************************************************************************* 
 * Created by: Jordan Hartwick
 * Date: May 29, 2016 @ 9:31 PM
 * Usage: java MatrixTranspose
 * 
 * Purpose: Transposes a matrix.
 * 
 * Test Run
 ***********************************
 * Type your matrix dimensions: 2 3
 * Type your matrix: 6 4 24 1 -9 8
 * [6, 1]
 * [4, -9]
 * [24, 8]
 */
public class MatrixTranspose {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Type your matrix dimensions: ");
		int[] dims = new int[2];
		
		// Get the dimensions of the transposed matrix.
		dims[1] = in.nextInt();
		dims[0] = in.nextInt();
		System.out.print("Type your matrix: ");	
		int[][] solution = new int[dims[0]][dims[1]];
		
		// Get the first column.
		for(int r = 0; r < dims[0]; r++) {
			solution[r][0] = in.nextInt();		
		}
		
		// Get the second column.
		for(int r = 0; r < dims[0]; r++) {
			solution[r][1] = in.nextInt();
			System.out.println(Arrays.toString(solution[r]));		
		}
	}
}
