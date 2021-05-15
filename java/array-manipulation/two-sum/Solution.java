class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> records = new HashMap<Integer, Integer>();
        for(int i= 0; i< nums.length; i++){
            int complementary = target - nums[i];
            if(records.containsKey(complementary)){
                return new int[] {i, records.get(complementary)};
            }
            records.put(nums[i], i);
        }
        return null;
    }
}