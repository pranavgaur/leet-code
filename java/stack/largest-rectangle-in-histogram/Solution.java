class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int len = heights.length;
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        
        for(int i = 0; i<=len; i++) {
            
            while(!stack.isEmpty() && (i == len || heights[stack.peek()] >= heights[i])){
                
                int poppedIdx = stack.pop();
                int height = heights[poppedIdx];
                int width = 0;
                if(stack.isEmpty()) width = i;
                else width = (i-stack.peek()-1);
                maxArea = Math.max(maxArea, height*width);    
            }

            stack.push(i);
            
        }
        
        return maxArea;
        
    }
}