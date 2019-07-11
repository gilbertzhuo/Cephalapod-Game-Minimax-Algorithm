import java.util.List;
import java.util.Vector;




public class Minimax {
	
     
	public static int miniMax(int player, Board board) {
		int score;
	
		if(board.checkEmpty()==false) {
			int total = 0;
			  for(int i =0; 3>i;i++){
			        for(int j = 0; 3>j; j++) {
			               total += board.grid[i][j];
			        }
			    }
			return total;
			
		}
		
		  Vector<Point> list = new Vector<Point>();
		for(int i = 0; i<3;i++) {
			for(int j=0; j<3;j++) {
				if(board.grid[i][j]==0) {
				   board.BoardMove(player, i+1, j+1);
				   board.capture(player, i+1, j+1);
					if(player == -1) {
					    score = miniMax(1,board);
					}else {
						score = miniMax(-1,board);
					}
					Point p = new Point(i,j,score);     
					list.add(p);
				}
			}
		}
		
	 
		int bestMove = 0;
		if(player == -1) {
			int bestScore = Integer.MIN_VALUE;
			for (int i = 0; i < list.size(); ++i) { 
	            if (bestScore  < list.get(i).score) {
	                bestScore = list.get(i).score;
	                bestMove = i;
	            }
	        }
		}else {
			if(player == 1) {
				int bestScore = Integer.MAX_VALUE;
				for (int i = 0; i < list.size(); ++i) { 
		            if (bestScore  > list.get(i).score) {
		                bestScore = list.get(i).score;
		                bestMove = i;
		            }
		        }
			}
		
			
			
		}
		int x =list.get(bestMove).row;
		int y =list.get(bestMove).col;
		int value = (x*3)+y+1;
		
		return value;
		
	}
	
	
	
	
	
}
	
	
