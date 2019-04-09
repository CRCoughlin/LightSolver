package light;

/**
 *
 */
/**
 * @author Christian R. Coughlin Mar 30, 2019
 */
public class Board {

    private int size;
    private int[][] matrix;

    public Board(int size) {
        this.size = size;
        matrix = new int[size][size];

    }

    public Board(int size, String numbers) {
        this.size = size;
        matrix = new int[size][size];

        setBoardValues(numbers);
    }

    public void setBoardValues(String numbers) {
        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Character.getNumericValue(numbers.charAt(index));
                index++;
            }
        }
    }

    private int[][] makeDefCond() {
        int[][] m = new int[size * size][size * size + 1];  // +1 For Gasussion
        int s = size * size;
        int c = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                m[size * i + j][c] = 1;
                if (j - 1 >= 0) {
                    m[size * i + (j - 1)][c] = 1;
                }
                if (i - 1 >= 0) {
                    m[size * (i - 1) + j][c] = 1;
                }
                if (j + 1 < size) {
                    m[size * i + (j + 1)][c] = 1;
                }
                if (i + 1 < size) {
                    m[size * (i + 1) + j][c] = 1;
                }
                c++;
            }
        }
        return m;
    }

    private int[] expected() {
        int[] a = new int[size * size];
        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                a[index++] = matrix[i][j];
            }

        }
        return a;
    }

    public String solveLight() {
        Gasussion g = new Gasussion(makeDefCond(), expected(), size);
        g.rowReduction();
        return translateResult(g.getResult());
    }

    private String translateResult(int[] result) {
        String str = new String();
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 1) {
                str += i + 1 + ", ";
            }
        }
        return str;
    }

    public String toString() {
        String str = new String();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                str += matrix[i][j] + ", ";
            }
        }
        str += "\n";
        return str;
    }
}
