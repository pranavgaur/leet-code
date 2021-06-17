class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int low = 0;
        int high = numbers.length - 1;
        
        while(high > low){
        
            int sum = numbers[high] + numbers[low];
        
            if(sum == target)
                return new int[]{low+1, high+1};
            
            if(sum < target)
                low++;
            else
                high--;
        
        }
        
        return new int[]{-1,-1};
               
    }
}