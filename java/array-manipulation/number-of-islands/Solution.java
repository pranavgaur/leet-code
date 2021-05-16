class Solution {
    
    // Global variable to store grid grid
    private char[][] grid;
    
    // Driver function
    public int numIslands(char[][] grid) {
        
        this.grid = grid;
        
        // Variable to store the count of islands
        int counter = 0;
        
        // Iterate through each element just once and check if it is a '1' or not
        // If it is a '1', increment the counter and expand accross that element 
        // in all directions, untill we encounter a '0'. Change the value of '1' 
        // elements we have accessed so far, to '2'.
        for(int i = 0; i< this.grid.length ; i++){
            for(int j = 0; j< this.grid[0].length ; j++){
                if(this.grid[i][j] == '1'){
                    counter++;
                    this.markIslands(i,j);
                }
            }
        }
        
        return counter;
    }
    
    public int markIslands(int i, int j){
        
        // Boundary condition check, for the coordinates received in resursive call
        if(i<0 || i>=this.grid.length || j<0 || j>=this.grid[0].length){
            return -1;
        } else {
            if(grid[i][j]=='1'){
                this.grid[i][j] = '2';
                markIslands(i-1, j);    // expand upwards
                markIslands(i, j+1);    // expand rightwards
                markIslands(i+1, j);    // expand downwards
                markIslands(i, j-1);    // expand leftwards
            }
        }
        
        return -1;
        
    }
}