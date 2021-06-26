class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        int maxSum = nums[0];
        int currentMaxSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            currentMaxSum = Math.max(nums[i], nums[i]+currentMaxSum);
            if(currentMaxSum > maxSum)
                maxSum = currentMaxSum;
        }
        return maxSum;
    }
}