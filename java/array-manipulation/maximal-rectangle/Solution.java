class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxArea = 0;
        
        int[] dpArr = new int[cols];
        
        for(int i = 0; i < rows; i++) {
            dpArr = getRow(matrix[i], dpArr); 
            maxArea = Math.max(maxArea, largestRectangleArea(dpArr));
        }
        
        return maxArea;
    }
    
    public int[] getRow(char[] arr, int[] row) {
        
        for(int j = 0; j < arr.length; j++) {
                if(arr[j] != '0')
                    row[j] = row[j]+1;
                else
                    row[j] = 0;
        }
        return row;
        
    }
    
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        int len = heights.length;
        
        for(int i = 0; i <= len; i++) {
            
            while(!stack.empty() && (i == len || heights[stack.peek()] >= heights[i])) {
                int poppedIdx = stack.pop();
                int width = 0;
                if(stack.empty())
                    width = i;
                else
                    width = i-stack.peek()-1;
                maxArea = Math.max(maxArea, width*heights[poppedIdx]);
            }
            
            stack.push(i);
        }
        
        return maxArea;
        
    }
}