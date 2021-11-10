class Solution {
    public boolean canJump(int[] nums) {

        if(nums[0] == 0 && nums.length != 1)
            return false;
        
        int reach = 1;
        
        for(int i = 0; i < nums.length; i++) {
            if(i > reach)
                return false;
            int currReach = i+nums[i];
            if(currReach > reach)
                reach = currReach;   
        }
        
        return true;
        
    }
}