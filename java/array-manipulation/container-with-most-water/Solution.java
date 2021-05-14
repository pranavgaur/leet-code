class Solution {
    public int maxArea(int[] height) {
        
	// pointers for left and right wall of the container
        int left = 0;
        int right = height.length-1;

	// variable to store the maximum area value so far
        int maxArea = 0;
	
	// shrink the search space & finding the next bigger height, by:
	// incrementing left pointer when height of left wall is smaller than right
	// and decrementing right pointer when height of right wall is smaller than left
        while(left < right){
            int width = right - left;
            int conheight = Math.min(height[left], height[right]);
            int currentArea = width*conheight;
            
            maxArea = Math.max(currentArea, maxArea);
            
            if(height[left]<height[right])
                left++;
            else
                right--;
        }
        
        return maxArea;
               
    }
}