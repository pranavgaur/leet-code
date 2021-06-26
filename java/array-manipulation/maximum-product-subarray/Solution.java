class Solution {
    public int maxProduct(int[] nums) {
        
        int length = nums.length;
        
        if(length == 1)
            return nums[0];
        
        int[] maxArray = new int[length];
        int[] minArray = new int[length];
        maxArray[0] = nums[0];
        int product = maxArray[0];
        
        for(int i = 1; i < length; i++){
            maxArray[i] = Math.max(nums[i], Math.max(maxArray[i-1]*nums[i], minArray[i-1]*nums[i]));
            minArray[i] = Math.min(nums[i], Math.min(maxArray[i-1]*nums[i], minArray[i-1]*nums[i]));
            product = Math.max(product, maxArray[i]);
        }
        
        return product;
    }
}