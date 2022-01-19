class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int len = nums.length;
        int res = 1;
        
        int[] dpArray = new int[len];
        dpArray[len-1] = 1;
        
        for(int i = (len-1); i >= 0; i--) {
            int length = 1;
            for(int j = (i+1); j < len; j++) {
                if(nums[j] > nums[i]){
                    length = Math.max(length, (dpArray[j]+1));
                }
            }
            dpArray[i] = length;
            res = Math.max(res, length);
        }
        
        return res;
        
    }
}