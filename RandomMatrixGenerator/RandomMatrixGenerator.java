import java.util.Arrays;
import java.util.Random;


/*******************************************************************************
 * Created by: Jordan Hartwick
 * Date: May 29, 2016 @ 9:50 PM
 * Usage: java RandomMatrixGenerator <rows> <columns> <maxvalue>
 *
 * Purpose: Generates a random matrix with a specified amount of rows and columns
 * where all values are less than the max value.
 *
 * Test Run:
 *******************************************************************************
 * java RandomMatrixGenerator 2 3 6
 * [0, 1, 4]
 * [1, 0, 1]
 */
public class RandomMatrixGenerator {
	
	public static void main(String[] args) {
		Random rand = new Random();
		if(args == null || args[0] == null || args[1] == null || args[2] == null) {
			System.out.println("Usage: java RandomMatrixGenerator rows columns maxvalue");
		}
		
		int rows = Integer.parseInt(args[0]), 
			cols = Integer.parseInt(args[1]), 
			maxV = Integer.parseInt(args[2]);
		
		int[][] matrix = new int[rows][cols];
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < cols; c++) {
				matrix[r][c] = rand.nextInt(maxV);
			}
			System.out.println(Arrays.toString(matrix[r]));
		}
	}
}
