class Solution {
    public int[][] setZeroes(int[][] matrix) {
        
        int rowZero = matrix[0][0];
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    if(i == 0)
                        rowZero = 0;
                    else
                        matrix[i][0] = 0;
                    matrix[0][j] = 0; 
                }
            }    
        }
        
        for(int i = matrix.length-1 ; i >= 0; i--){
            for(int j = matrix[0].length-1 ; j >= 0; j--){
                if(i != 0) {
                    if(matrix[i][0] == 0 || matrix[0][j] == 0)
                        matrix[i][j]=0;
                } else {
                    if(rowZero == 0)
                        matrix[i][j]=0;
                }
            }
        }
        
        return matrix;
        
    }
}