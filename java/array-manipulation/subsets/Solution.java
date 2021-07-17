class Solution {
    
    List<List<Integer>> resList = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> subsets(int[] nums) {
        
        Arrays.sort(nums);
        resList.add(new ArrayList<Integer>());    
        createSubsets(nums, 0, new ArrayList<Integer>());   
        return resList;
        
    }
    
    void createSubsets(int[] nums, int i, List<Integer> currList) {
        
        if(i == nums.length)
            return;
        else{
            for(int k = i; k < nums.length; k++){
                if(k == i || nums[k] != nums[k-1]){
                    currList.add(nums[k]);
                    resList.add(new ArrayList<Integer>(currList));
                    createSubsets(nums, k+1, currList);  
                    currList.remove(currList.size() -1);
                }
            }
        }
        
    }
}