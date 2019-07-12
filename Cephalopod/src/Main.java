import java.util.Scanner;

public class Main {
  
    
	public static void main(String[] args) {
		int player = 1;
		System.out.println("\nWelcome to Cephalopod Game");
		
		Board small = new Board(3,3);
        Scanner scan = new Scanner(System.in);
        int row;
        int col;
		do {
			do {
		    System.out.println("ROW:");
		       row = scan.nextInt();
			System.out.println("COL:");
			    col = scan.nextInt();
			}while(small.validMove(row, col)==false);
			small.BoardMove(player, row, col);
		    if(small.checkNeighbour(row-1, col-1)>=2) {
			small.capture(player, row, col);
		    }
		    
			
			small.printBoard();
			
			if(small.checkEmpty()==true) {
			Minimax max = new Minimax();
		    Board temp = new Board(small);
		    temp.printBoard();
			Point p =  max.findBestMove(temp, player);
		    small.BoardMove(-1, p.row+1, p.col+1);
		    if(small.checkNeighbour(p.row, p.col)>=2) {
		    small.capture(-1,p.row+1,p.col+1);
		    }
			small.printBoard();
			}
		
			

		}while(small.checkEmpty()==true);
		
		small.checkWin();
		
	
	
	}

}
