class Solution {
    public int jump(int[] nums) {
        
        int left = 0, right = 0, jumps = 0;
        
        while(right < nums.length-1){
            int maxRange = 0;
            for(int i = left; i <= right; i++) {
                maxRange = Math.max(maxRange, i+nums[i]);
            }
            left = right+1;
            right = maxRange;
            jumps+=1;
        }
        
        return jumps;
        
    }
}