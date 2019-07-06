
public class Board {
	String a = "x";
	int grid[][] = new int [3][3];
	
	public Board(int row, int col) {
	  printBoard(3,3);
	}
	
	
	
	void printBoard (int row, int col) {
		 System.out.println("BOARD GAME\n");
		    //Designing the top

		    
		    for (int i = 0; i < row; i++) {
		  
		        
		        for (int j = 0; j < col; j++) {
		            if (grid[i][j] == 0) {
		                System.out.print("  -");
		                
		                if(j !=2) {
		                 System.out.print("  |");
		                }
		               
		            } else if (grid[i][j] > 0) {
		            	System.out.print(" "+grid[i][j]+" |");
		                
		            } else if (grid[i][j] < 0) {
		                System.out.print(""+grid[i][j]+" |");
		            }
		        }
		        System.out.print("\n");
		        if(i !=2) {
		        System.out.print(" ---------------");
		        System.out.print("\n");
		        }
		    }
	
		
	}

}
