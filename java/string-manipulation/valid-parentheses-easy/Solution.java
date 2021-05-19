class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack();
        
        for(char c : s.toCharArray()){
            switch(c){
                case ')':{
                    if(stack.empty() || stack.pop() != '(')
                        return false;
                }
                break;
                    
                case '}':{
                    if(stack.empty() || stack.pop() != '{')
                        return false;
                }
                break;
                    
                case ']':{
                    if(stack.empty() || stack.pop() != '[')
                        return false;
                }
                break;
                
                default: {
                    stack.push(c);
                }
                break;
            }
        }
        
        if(stack.empty())
            return true;
        
        return false;       
        
    }
}