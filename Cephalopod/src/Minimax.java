import java.util.*;
import java.lang.*;
import java.io.*;



public class Minimax {
    Point findBestMove(Board board,int player) 
	{ 
	    int bestVal = Integer.MIN_VALUE;
	    Point bestMove = new Point(-1,-1,1);
	 
	    for (int i = 0; i<3; i++) 
	    { 
	        for (int j = 0; j<3; j++) 
	        { 
	            // Check if cell is empty 
	            if (board.grid[i][j]==0) 
	            { 
	            	Board temp = new Board(board);
	                // Make the move 
	                temp.BoardMove(player, i+1, j+1);
	                temp.capture(player, i+1, j+1);
	                
	                // compute evaluation function for this 
	                // move. 
	                int moveVal = miniMax(player,temp); 
	  
	                // If the value of the current move is 
	                // more than the best value, then update 
	                // best/ 
	                if (moveVal > bestVal) 
	                { 
	                    bestMove.row = i; 
	                    bestMove.col = j; 
	                    bestVal = moveVal; 
	                } 
	            } 
	        } 
	    } 
	  
	
	    return bestMove; 
	} 
	public int miniMax(int player, Board board) {
		
		//Check for empty
		if(board.checkEmpty()==false) {
			int total = 0;
			  for(int i =0; 3>i;i++){
			        for(int j = 0; 3>j; j++) {
			               total += board.grid[i][j];
			        }
			    }
			//Getting the score
			if(total ==0) {
				return 0;
			}else if(total >1) {
				return -10;
			}else { return 10;}
		}
			
	if(player == -1) {
		int best = Integer.MIN_VALUE;
		 for (int i = 0; i<3; i++) 
	        { 
	            for (int j = 0; j<3; j++) 
	            { 
	                // Check if cell is empty 
	                if (board.grid[i][j]==0) 
	                { 
	                    // Make the move 
	                
	                    board.BoardMove(player, i+1, j+1);
	                    board.capture(player, i+1, j+1);
	                    best = Math.max( best, 
	                        miniMax(-1,board) ); 
	                  
	                } 
	            } 
	        } 
		 return best;
	}else {
		int best = Integer.MAX_VALUE;
	
		 for (int i = 0; i<3; i++) 
	        { 
	            for (int j = 0; j<3; j++) 
	            { 
	                // Check if cell is empty 
	                if (board.grid[i][j]==0) 
	                { 
	                    
	                    board.BoardMove(player, i+1, j+1);
	                    board.capture(player, i+1, j+1);
	                    best = Math.min( best, 
	                        miniMax(1,board) ); 
	                    
	                } 
	            } 
	        } 
		 return best;
		
		
	}
	
	
	
}
}

	