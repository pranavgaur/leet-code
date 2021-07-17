class Solution {
    public int orangesRotting(int[][] grid) {
        
        int status = 2;
        boolean updated = false;
        int minutes = 0;
        
        do{ 
            updated = false;
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    if(grid[i][j] == status){
                        if(i-1 >= 0 && grid[i-1][j] == 1){
                            grid[i-1][j] = status + 1;
                            updated = true;
                        }
                        
                        if(j+1 < grid[0].length && grid[i][j+1] == 1){
                            grid[i][j+1] = status + 1;
                            updated = true;
                        }
                        
                        if(i+1 < grid.length && grid[i+1][j] == 1){
                            grid[i+1][j] = status + 1;
                            updated = true;
                        }
                        
                        if(j-1 >= 0 && grid[i][j-1] == 1){
                            grid[i][j-1] = status + 1;
                            updated = true;
                        }
                           
                    }
                }    
            }
            
            if(updated){
                minutes++;
                status++;
            }
            
        }while(updated);
        
        for(int i = 0; i<grid.length; i++){
                for(int j = 0; j<grid[0].length; j++){
                    if(grid[i][j]==1)
                        minutes = -1;
                }
        }
        
        return minutes;
        
    }
}