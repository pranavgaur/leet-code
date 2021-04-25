// Check valid paranthesis string
class Solution {
    public boolean checkValidString(String s) {
	
	// Stack to keep track of opening brackets
        Stack<Integer> opening = new Stack<Integer>();
		
	// Stack to keep track of stars
        Stack<Integer> stars = new Stack<Integer>();
        
	// Convert string to character array
        char[] arr = s.toCharArray();
        
	// Loop through the entire string
        for(int i=0 ; i<s.length(); i++){
		
		// Push the index of opening brackets in opening stack
            	if(s.charAt(i) == '(')
                	opening.push(i);
            
		// Push the index of stars in stars stack
            	if(s.charAt(i) == '*')
                	stars.push(i);
            
		// In case of closing bracket, pop from opening stack
		// If, opening stack is empty, pop from star stack
		// If, star stack is also empty, it means, string is invalid
            	if(s.charAt(i) == ')') {
                	if(!opening.empty())
                    		opening.pop();
                else if(!stars.empty())
                    	stars.pop();
                else
                    	return false;
            }
        }

	// After complete iteration, if opening stack is not empty,
	// Balance them with the stars such that, the higher index 
	// star can balance lower index opening bracket
	// If, above condition fails, it means, string is invalid
        while(!opening.empty() && !stars.empty()){
            int j = opening.pop();
            int k = stars.pop();
            if(j>k)
                return false;
        }
        
	// Finally, check if all opening brackets are balanced or not
        if(!opening.empty()){
            return false;
        }
        
	// Finally, return true if code doesn't fail anywhere above
        return true;
               
    }
}
