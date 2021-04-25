// Longest substring without repeating characters
// Sliding window algorithm
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
	// Edge case
        if(s.length() < 2)
            return s.length();
        
	// Initialising a 255-bit counter array with 0
        int[] counter = new int[255];
        Arrays.fill(counter, 0);
        
	// Marker variables to mark window start & end
        int i=0, j=0;
        
	// Variable to store longest length value
        int ans = 1;
        
	// Convert string to character array
        char[] arr = s.toCharArray();
		
	// Open the window with fist(0th) character 
        counter[arr[0]]++;
		
	// Loop untilt the end of window reaches the end of string
        while(j!=s.length()-1){
		
		// Check if the (end marker position + 1)th
		// element in string is unique in window
		// If yes, expand the window and recheck max length
		// If not, shrink the window from starting, &
		// reset the bit for elements which are now out of window
		if(counter[arr[j+1]] == 0){
			j++;
			counter[arr[j]]=1;
			ans = Math.max(ans, j-i+1);
		} else {
			counter[arr[i]] = 0;
			i++;
		}
        }
        
	// Finally return the longest sub string
        return ans;
                
    }
}
