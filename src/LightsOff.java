import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Christian R. Coughlin
 * Mar 30, 2019 
 */
public class LightsOff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int size;
		String numbers;
		Board board;
		
		size = Integer.parseInt(JOptionPane.showInputDialog("Size of the board(n x n), greater than 1?"));
		
		numbers = JOptionPane.showInputDialog("Enter " + (size * size) + " values from Top-Left to Bottom-Right:\nEX. n=3, 101110011\n1 = Light On\n0 = Light Off\n");
	
		board = new Board(size, numbers);
	
		int[] results = board.solveLight();
		
		System.out.println("Click");
		for(int i=0; i<results.length; i++) 
			System.out.println(results[i]);
		
	}
}
