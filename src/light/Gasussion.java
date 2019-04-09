package light;

/**
 *
 */
/**
 * @author Christian R. Coughlin Mar 30, 2019
 */
public class Gasussion {

    private int[][] matrix;
    private int size;

    public Gasussion(int[][] m, int[] expect, int s) {
        this.size = s * s;
        matrix = m;
        for (int i = 0; i < size; i++) {
            matrix[i][size] = expect[i];
        }
    }

    public void rowReduction() {
        int pivot;
        int lastP = -1;
        for (int i = 0; i < size; i++) {	// through Col
            pivot = findPivot(i, lastP);
            lastP = pivot;
            if (pivot > -1) {
                for (int j = 0; j < size; j++) {
                    if (matrix[j][i] == 1 && j != pivot) {
                        addTo(pivot, j);
                    }
                }
            }
        }
    }
    
    public void RRDisplay(){ // missing swap
        System.out.println(toString() + "\n");
        int pivot;
        int lastP = -1;
        for (int i = 0; i < size; i++) {	// through Col
            pivot = findPivot(i, lastP);
            System.out.println("P: " + pivot + "  LP: " + lastP);
            lastP = pivot;
            if (pivot > -1) {
                for (int j = 0; j < size; j++) {
                    if (matrix[j][i] == 1 && j != pivot) {
                        addTo(pivot, j);
                        System.out.println("Added " + pivot + " to " + j);
                    }
                }
            }
            System.out.println(toString() + "\n");
        }
    }

    private void swap(int from, int to) {
        int[] row = matrix[from];
        matrix[from] = matrix[to];
        matrix[to] = row;
    }

    private void addTo(int from, int to) {
        for (int i = 0; i < size + 1; i++) {
            if (matrix[from][i] == 1) {
                if (matrix[to][i] == 1) {
                    matrix[to][i] = 0;
                } else {
                    matrix[to][i] = 1;
                }
            }
        }
    }

    private int findPivot(int col, int lastP) {      // TODO:improve for a perfect cross if possable.
        for (int i = lastP + 1; i < size; i++) {
            if (matrix[i][col] == 1) {
                if (i == lastP + 1) // still in a perfect cross
                {
                    return i;
                } else if (i > lastP + 1) {	// below
                    swap(i, col);
                    return col;
                }
            }
        }
        return col;             
    }

    public int[] getResult() {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = matrix[i][size];
        }
        return result;
    }

    @Override
    public String toString() {
        String str = new String();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size + 1; j++) {
                str += matrix[i][j] + " ";
            }
            str += "\n";
        }
        return str;
    }

}
