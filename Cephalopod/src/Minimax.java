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
	        	
	            if (board.grid[i][j]==0) 
	            { 
	            	Board temp = new Board(board);
	               
	                temp.BoardMove(player, i+1, j+1);
	                temp.capture(player, i+1, j+1);
	                
	            
	                int moveVal = miniMax(1,temp); 
	  
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
		
		
		if(board.checkEmpty()==false) {
			int total = 0;
			  for(int i =0; 3>i;i++){
			        for(int j = 0; 3>j; j++) {
			               total += board.grid[i][j];
			        }
			    }
			  
			if(total ==0) {
				return 0;
			}else if(total >1) {
				return -10;
			}else { return 10;}
		}
			
	if(player == 1) {
		int best = Integer.MIN_VALUE;
		 for (int i = 0; i<3; i++) 
	        { 
	            for (int j = 0; j<3; j++) 
	            { 
	            
	                if (board.grid[i][j]==0) 
	                { 
	             
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

	