class Solution {
    public int longestValidParentheses(String s) {
        
        if(s.length() == 0)
            return 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        
        int maxLength = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                stack.push(i);
            else {
                stack.pop();
                if(stack.empty()){
                    stack.push(i);
                }
                int currLen = i - stack.peek();
                maxLength = Math.max(maxLength, currLen);
            }
        }
        
        return maxLength;
        
    }
}