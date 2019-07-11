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
			small.capture(player, row, col);
			small.printBoard();
			
			
			if(small.checkEmpty()==true) {
			Minimax max = new Minimax();
			Point p =  max.findBestMove(small, player);
		    small.BoardMove(-1, p.row, p.col);
			small.printBoard();
			}
		
			

		}while(small.checkEmpty()==true);
		
		small.checkWin();
		
	
	
	}

}
