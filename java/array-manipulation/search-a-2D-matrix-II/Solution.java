class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        // Start with the last element in first row
        int col = matrix[0].length - 1;
        int row = 0;
        
        // Iterate until, the values of row and column are within the bounds
        while(col>=0 && row <= matrix.length-1){
            
            // If target value is equal to the current coordinates, return true
            if(target == matrix[row][col])
                return true;
            
            // If target value is less than current coordinate value, decrement column
            // If target value is more than current coordinate value, increment row
            if(target < matrix[row][col])
                col--;
            else
                row++;
        }
        
        return false;
        
    }
}