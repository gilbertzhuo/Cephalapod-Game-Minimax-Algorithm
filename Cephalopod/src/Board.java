import java.lang.Math; 
import java.util.Vector;

public class Board {
	
	int grid[][] = new int [3][3];
	
	public Board(int row, int col) {
		 for (int i = 0; i < row; i++) {
		        for (int j = 0; j < col; j++) {
		            grid[i][j] = 0;
		        }
		    }

	  printBoard();
	}
	

	public Board(Board b) {
		
		
		 for (int i = 0; i < 3; i++) {
		        for (int j = 0; j < 3; j++) {
		            grid[i][j] = b.grid[i][j];
		        }
		    }
	}
	
	
	boolean validMove(int row, int col) {
		if(grid[row-1][col-1]==0) {
			return true;
		}
		return false;
	}
	void BoardMove(int player, int row, int col) {
		grid[row-1][col-1] = player;
	}
	
	void printBoard () {
		 System.out.println("BOARD GAME\n");
		    //Designing the top

		    
		    for (int i = 0; i < 3; i++) {
		  
		        
		        for (int j = 0; j < 3; j++) {
		            if (grid[i][j] == 0) {
		                System.out.print("  -");
		                
		                if(j !=2) {
		                 System.out.print("  |");
		                }
		               
		            } else if (grid[i][j] > 0) {
		            	System.out.print("  "+grid[i][j]);
		                if(j !=2) {
			                 System.out.print("  |");
			                }
		                
		            } else if (grid[i][j] < 0) {
		                System.out.print(" "+grid[i][j]);
		                if(j !=2) {
			                 System.out.print("  |");
			                }
		            }
		        }
		        System.out.print("\n");
		        if(i !=2) {
		        System.out.print(" ---------------");
		        System.out.print("\n");
		        }
		    }
	
		
	}
    
	
	boolean checkEmpty() {
		
		for(int i= 0; 3>i;i++){
	        for(int j=0; 3>j;j++){
	          if(grid[i][j]==0){
	             return true;
	          }
	        }
	    }
	    return false;
	}
	
	int checkWin() {
		  int total = 0;
		    for(int i =0; 3>i;i++){
		        for(int j = 0; 3>j; j++) {
		               total += grid[i][j];
		        }
		    }
		    //If total is positive, player A win, if negative, player B wins
		    if(total > 0){

		        System.out.println("Player A wins ! HOORAY!");

		        return -1;
		    }
		    else{
		    	System.out.println("Player B wins ! HOORAY");
		    	return 1;
		    }
			
	}
	
	
	
	void capture(int player,int row, int col) {
		int up,down,left,right;
		int highest = 0;
		int num1=4;
		int num2=4;
		int num3=4;
		int num4=4;
		if(row-2>=0) {
		 up = Math.abs(grid[row-2][col-1]);
		}else {
			up = 100;
		}
		if(col-2>=0) {
		 left = Math.abs(grid[row-1][col-2]);
		}else {
			left = 100;
		}
		if(row<3) {
	     down = Math.abs(grid[row][col-1]);
		}else {
			down = 100;
		}
		if(col<3) {
	     right = Math.abs(grid[row-1][col]);
		}else {
			right = 100;
		}
		  //Store inside the list to retrieve
	     int list[]={up,down,left,right};

	   //Combination of 2
	     for(int j = 3; 0<=j;j--) {
	         for (int i = 0; j > i; i++) {
	             if((list[i] + list[j])>highest && (list[i] + list[j])<=6) {
	                 if(list[i] != 0 && list[j] != 0) {
	                     highest = list[i] + list[j];
	                     num1 = i;
	                     num2 = j;
	                 }
	             }
	         }
	     }
	  // Combination of 4 A+B+C+D
	     if (up+down+left+right <= 6 && highest<up+down+left+right){

	         highest = up+down+left+right;
	         num1 = 0;
	         num2 = 1;
	         num3 = 2;
	         num4 = 3;
	     }

	     //Combination of 3
	     if(up+down+left <= 6 && highest<up+down+left ){
	         highest = up+down+left;
	         num1 = 0;
	         num2 = 1;
	         num3 = 2;
	     }

	     if(up+down+right <= 6 && highest<up+down+right ) {
	         highest = up + down + right;
	         num1 = 0;
	         num2 = 1;
	         num3 = 3;
	     }

	     if(down+left+right <= 6 && highest<down+left+right ){
	         highest = down+left+right;
	         num1 = 1;
	         num2 = 2;
	         num3 = 3;

	     }

	     if(up+left+right <= 6 && highest<up+left+right ){
	         highest = up+left+right;
	         num1 = 0;
	         num2 = 2;
	         num3 = 3;
	     }

	     if(highest != 0) {
	         grid[row-1][col-1] = highest * player;
	     }
	     
	     if(num1 == 0 || num2 == 0 || num3 == 0 || num4 == 0) {
	         if(up != 0) {
	        	 grid[row-2][col-1] = 0;
	         }
	      

	     }

	    if(num1 == 1 || num2 == 1 || num3 == 1 || num4 == 1) {
	        if(down != 0) {
	        	grid[row][col-1] = 0;
	        }
	       

	    }

	     if(num1 == 2 || num2 == 2 || num3 == 2 || num4 == 2) {
	         if(left !=0 ) {
	        	 grid[row-1][col-2] = 0;
	         }
	         
	     }


	     if(num1 == 3 || num2 == 3 || num3 == 3 || num4 == 3) {
	         if(right != 0) {
	        	 grid[row-1][col] = 0;
	         }
	       

	     }


	    
	     
	     
	  
	}
	int checkNeighbour(int x, int y) {
		    int num = 0;
		 

		    if(x-1>=0 && grid[x-1][y] !=0 ) {
		        num++;
		    }
		    if(x+1<3 && grid[x+1][y] !=0) {
		        num++;
		    }
		    if(y+1<3 && grid[x][y + 1] != 0) {
		        num++;
		    }
		    if(y-1>=0 && grid[x][y - 1] != 0 ) {
		        num++;
		    }
		  


		  return num;
	};
}
