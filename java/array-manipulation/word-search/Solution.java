class Solution {
    
    public boolean exist(char[][] board, String word) {
        
        int rows = board.length;
        int cols = board[0].length;
        int wordLength = word.length();
        
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if(word.charAt(0) == board[i][j] && traverse(word, 0, board, j, i, rows, cols, wordLength))
                    return true;
            }     
        }
        
        return false;
        
    }
    
    boolean traverse(String word, int i, char[][] board, int col, int row, int rows, int cols, int wordLength) {
      
        if(i == wordLength)
            return true;
        else{
            if(col < 0 || col >= cols || row < 0 || row >= rows || board[row][col] != word.charAt(i))
                return false;
            else{
                board[row][col] = ' ';
                boolean ans = traverse(word, i+1, board, col+1, row, rows, cols, wordLength) ||
                traverse(word, i+1, board, col, row+1, rows, cols, wordLength) ||
                traverse(word, i+1, board, col-1, row, rows, cols, wordLength) ||
                traverse(word, i+1, board, col, row-1, rows, cols, wordLength);
                board[row][col] = word.charAt(i);
                return ans;
            }
        }
    }
}