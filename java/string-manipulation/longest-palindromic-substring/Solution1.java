// Longest palindromic substring
// Dynamic programing solution
class Solution1 {
    public String longestPalindrome(String s) {
        
	// Varibale to store the length of string
        int n = s.length();
        
	// Edge condition check
        if(n < 2)
            return s;
        
	// Table to track the plaindromic string
        int[][] table = new int[n][n];
        
	// Varibale to store maximum length value
        int max = 1;
		
	// Variable to store the starting index of longest plaindromic substring
        int start = 0;
        
	// Loop across and track the strings of length 1 (i.e. diagonal elements)
	// All single characters are palindrome
        for(int i = 0; i < n ; i++)
            table[i][i] = 1;
        
	// Loop across and track the strings of length 2
	// Check if they are plaindrome or not and mark 
	// the corresponding [row, col] in table as 1
        for(int i=0; i< n-1 ; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                table[i][i+1]=1;
                max = 2;
                start = i;
            }     
        }
        
	// Iterate through the string for string of length 3 to N(string length)
	// Check if the first and last characters are same and then check if the
	// previous cells in table are plaindrome or not. Keep track of max 
	// length and starting index
        int gap = 3;
		
        while(gap <= n){
            for(int i=0; i<n-gap+1; i++) {
                int j = i+gap-1;
                if(s.charAt(i) == s.charAt(j) && table[i+1][j-1]==1){
                    table[i][j] = 1;
                    if(gap>max){
                        max = gap;
                        start = i;
                    }
                }
                    
            }
            gap++;
        }
        
	// Edge condition if start and max come up to be 0
        if(start == 0 && max == 0)
            return s.charAt(start)+"";
        
        return s.substring(start,start+max);
                
    }
}
