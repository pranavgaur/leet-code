class Solution {
    
    List<List<Integer>> resList = new ArrayList();
    
    public List<List<Integer>> permute(int[] nums) {
        driverFunction(nums, 0);
        return resList;
    }
    
    void driverFunction(int[] nums, int j){
       
        if(j == nums.length){
            resList.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
     
        } else {
            
            for(int i = j; i < nums.length; i++){
                swap(nums, j, i);
                driverFunction(nums, j+1);
                swap(nums, j, i);
            }
            
        }
        
    }
    
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}