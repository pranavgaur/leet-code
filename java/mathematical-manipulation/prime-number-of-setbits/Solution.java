// Prime number of set bits in binary representation
class Solution {
    public int countPrimeSetBits(int L, int R) {
        
	// Variable to count the number of prime bit sets
        int count = 0;
        
	// Loop from start to end 
        while(L <= R){
		
		// Check if the current number has prime number of bitsets
		// Increment the counter if true
        	if(hasPrimeBit(L))
                	count++;
				
            	L++;
        }
        
	// Return the count value
        return count;
        
    }
    
    // Variable to check if the number has prime number of bitsets
    Boolean hasPrimeBit(int num) {
		
	int bitCount = Integer.bitCount(num);
        
        return (x == 2 || x == 3 || x == 5 || x == 7 ||
                x == 11 || x == 13 || x == 17 || x == 19 ||
				x == 23 || x == 29 || x == 31);
    }
    
}
