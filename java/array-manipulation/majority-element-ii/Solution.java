class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> res = new ArrayList<Integer>();
        
        int elem1 = -1;
        int elem2 = -2;
        
        int count1 = 0;
        int count2 = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == elem1)
                count1++;
            else if(nums[i] == elem2)
                count2++;
            else if(count1 == 0) {
                elem1 = nums[i];
                count1++;
            } else if(count2 == 0) {
                elem2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == elem1)
                count1++;
            if(nums[i] == elem2)
                count2++;
        }
        
        if(count1 > nums.length/3)
            res.add(elem1);
        if(count2 > nums.length/3)
            res.add(elem2);
        
        return res;
        
    }
}