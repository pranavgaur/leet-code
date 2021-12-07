class Solution {
    public int jump(int[] nums) {
        int[] result = new int[nums.length];
        
        int t = nums[0];
        int max = 0;
        int pos = 0;
        int prev = 0;
        int i = 1;
        while(i<=t && i<nums.length) {
            if(max < nums[i] + i) {
                max = nums[i] + i ;
                pos = i;
            }
            
            result[i] = result[prev] + 1;
            
            if(i == t) {
                if(max > t) {
                    t = max;
                    max = 0;
                    prev = pos;
                } else {
                    t = nums[i] + i;
                    max = 0;
                    prev = i;
                }
            }
            i++;
        }
        
        return result[result.length - 1];
    }
}