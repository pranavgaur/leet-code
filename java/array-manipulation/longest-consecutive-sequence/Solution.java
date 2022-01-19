class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length == 0)
            return 0;
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        int maxLen = 1;
        
        for(int i = 0; i < nums.length; i++) {
            int currLen = 1;
            if(!set.contains(nums[i]-1)){
                int currVal = nums[i]+1;
                while(set.contains(currVal)){
                    currLen+=1;
                    currVal+=1;
                }
                maxLen = Math.max(currLen, maxLen);
            }
        }
        
        return maxLen;
        
    }
}