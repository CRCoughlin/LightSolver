/**
 * 
 */

/**
 * @author Christian R. Coughlin
 * Mar 30, 2019 
 */
public class Gasussion {
	// Gaussian row reduction
    public static int[] reduction(int[][] matrix) {
        int n=0;
		for (int p = 0; p < n; p++) {

            int max = p;
            for (int i = p + 1; i < n; i++) {
                if (Math.abs(matrix[i][p]) > Math.abs(matrix[max][p])) {
                    max = i;
                }
            }
            int[] temp = matrix[p]; matrix[p] = matrix[max]; matrix[max] = temp;

            for (int i = p + 1; i < n; i++) {
                int alpha = matrix[i][p] / matrix[p][p];
                for (int j = p; j < n; j++) {
                	matrix[i][j] -= alpha * matrix[p][j];
                }
            }
        }

        int[] x = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += matrix[i][j] * x[j];
            }
        }
        return x;
    }

    // TEMP code
    public static void main(String[] args) {
        int[][] test = {
            { 0, 1, 0 },
            { 0, 0, 0 },
            { 0, 1, 1 }
        };
        /*double[][] A = {
        	{1, 1, 0, 0, 0},
        	{1, 1, 1, 0, 0},
        	{0, 0, 0, 1, 1},
        	{0, 0, 0, 1, 1},
        	{0, 1, 1, 0, 1}
        };*/
        int[] result = reduction(test);

        System.out.println("Click:");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

}
