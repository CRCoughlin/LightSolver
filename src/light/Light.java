package light;

import javax.swing.JOptionPane;
import java.util.regex.Matcher;

/**
 * @author Christian R. Coughlin Mar 30, 2019
 */
public class Light {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String size;
        int s;
        String numbers;
        String title = "Solve Lights";
        Board board;
        int trys = 0;

        do {
            size = JOptionPane.showInputDialog(null, "Size of the board(n x n), greater than 1?", title, JOptionPane.INFORMATION_MESSAGE);
            if (trys == 3) {
                JOptionPane.showMessageDialog(null, "Too many tries.", title, JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            title = "Solve Lights: Not a number";
            trys++;
        } while (!size.matches("[0-9]+"));
        s = Integer.parseInt(size);
        trys = 0;
        title = "Solve Lights";

        do {
            numbers = JOptionPane.showInputDialog(null, "Enter " + (s * s) + " values from Top-Left to Bottom-Right:\nEX. n=3, 101110011\n1 = Light On\n0 = Light Off\n", title, JOptionPane.INFORMATION_MESSAGE);
            if (trys == 3) {
                JOptionPane.showMessageDialog(null, "Too many tries.", title, JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            title = "Solve Lights: Invalid input";
            trys++;
        } while (numbers.length() != s * s || !numbers.matches("[0-9]+"));

        board = new Board(s, numbers);
        JOptionPane.showMessageDialog(null, "Click positions: " + board.solveLight(), "Solve Lights", JOptionPane.INFORMATION_MESSAGE);
    }
}
