
/**
 * 
 */

/**
 * @author Christian R. Coughlin
 * Mar 30, 2019 
 */
public class Board {
	private int size;
	private int[][] matrix;


	public Board(int size){
		this.size = size;
		matrix= new int[size][size];

	}

	public Board(int size, String numbers) {
		this.size = size;
		matrix= new int[size][size];
		
		setBoardValues(numbers);
	}
	
	public int[] solveLight() {
		return Gasussion.reduction(matrix);
	}
	
	public void clickPoint(Point point){
		Point atPoint = point;
		Point hold = new Point(point.X,point.Y);
		//System.out.println(atPoint.toString() + "Start Size-" + size);//!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		while( (atPoint.X >= 0 && atPoint.X <= size - 1) && (atPoint.Y >= 0 && atPoint.Y <= size - 1) )//Going with center and right up
		{
			pointBoard[atPoint.Y][atPoint.X].flop();
			atPoint.X++;
			atPoint.Y--;
			//System.out.println(atPoint.toString() + "First looper" + atPoint.getX() + ", " + atPoint.getY());//!!!!!!!!!!!!!!!!!!!!!!!!!!!
		}

		atPoint.copyPoint(hold);
		//System.out.println(atPoint.toString() + "CHECK RESET1" + "tobe" + hold.toString());
		while( (atPoint.X-1 >= 0 && atPoint.X-1 <= size - 1) && (atPoint.Y-1 >= 0 && atPoint.Y-1 <= size - 1) )// Going from center, left up
		{
			atPoint.X--;
			atPoint.Y--;
			pointBoard[atPoint.Y][atPoint.X].flop();//out of bound , check it
		//	System.out.println(atPoint.toString() + "Second looper");//!!!!!!!!!!!!!!!!!!!!!!!!!!!
		}

		atPoint.copyPoint(hold);
		while( (atPoint.X-1 >= 0 && atPoint.X-1 <= size - 1) && (atPoint.Y+1 >= 0 && atPoint.Y+1 <= size - 1) )//Going from center, left down
		{
			atPoint.X--;
			atPoint.Y++;
			pointBoard[atPoint.Y][atPoint.X].flop();
			//System.out.println(atPoint.toString() + "Third looper");//!!!!!!!!!!!!!!!!!!!!!!!!!!!
		}

		atPoint.copyPoint(hold);
		while( (atPoint.X+1 >= 0 && atPoint.X+1 <= size - 1) && (atPoint.Y+1 >= 0 && atPoint.Y+1 <= size - 1) )//Going form center, right down
		{
			atPoint.X++;
			atPoint.Y++;
			pointBoard[atPoint.Y][atPoint.X].flop();
		//	System.out.println(atPoint.toString() + "End loop");//!!!!!!!!!!!!!!!!!!!!!!!!!!!
		}
	}

	public void setBoardValues(String numbers)
	{
		int index = 0;

		for(int i = 0; i < size; i ++)
			for(int j = 0; j < size; j++)
			{
				pointBoard[i][j].setValue((numbers.charAt(index)));
				index++;
			}
	}

	public String toString(){
		String str = new String();
		for(int i = 0; i < size; i ++)
			for(int j = 0; j < size; j++)
				str += matrix[i][j] + ", ";
			str += "\n";
		return str;
	}
}
