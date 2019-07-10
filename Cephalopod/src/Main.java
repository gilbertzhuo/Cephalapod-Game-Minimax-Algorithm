import java.util.Scanner;

public class Main {
  
    
	public static void main(String[] args) {
		int player = 1;
		System.out.println("\nWelcome to Cephalopod Game");
		
		Board small = new Board(3,3);
        Scanner scan = new Scanner(System.in);
		do {
		    System.out.println("ROW:");
			int row = scan.nextInt();
			System.out.println("COL:");
			int col = scan.nextInt();
			small.BoardMove(player, row, col);
			small.printBoard();
			//I think something is wrong with my copy constructor
			Board temp = new Board(small);
			int value = Minimax.miniMax(-1, temp);
			int x = (value-1)/3;
	        int y = (value-1)%3;
	        small.BoardMove(-1,x+1,y+1);
			small.printBoard();
		
			

		}while(small.checkEmpty()==true);
		
		small.checkWin();
		
	
	
	}

}
