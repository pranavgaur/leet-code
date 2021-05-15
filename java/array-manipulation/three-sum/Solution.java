class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
	
	// Boundary condition check to return empty list in case of array size less than 3 
        if(nums.length < 3)
            return Collections.emptyList();
        
	// Map to store the items
        Map<String, List<Integer>> map = new HashMap();
        
	// Iterate through the array once
        for(int i=0;i<nums.length-1;i++){

	    // The problem is now reduced to 2 sum problem.
	    // Find the complementary target to search for in the remaining array	
            int target = 0-nums[i];

	    // Set to keep track of complement values
            Set<Integer> set = new HashSet();
            
	    // Iterate through the remaining array and find the unique pairs of numbers having sum = target
            for(int j=i+1;j<nums.length;j++){
                int target2 = target - nums[j];
                if(set.contains(target2)){
                    List list = Arrays.asList(nums[i], nums[j], target2);
                    Collections.sort(list);
                    String key = getKey(list);
                    map.put(key, list);
                }
                set.add(nums[j]);
            }
            
        }
        
        return new ArrayList(map.values()); 
    }
    
    // Helper method to get string for pairs to ensure unique pairs
    public String getKey(List<Integer> list) {
        return list.get(0) + "" + list.get(1) + "" + list.get(2);
    }
}