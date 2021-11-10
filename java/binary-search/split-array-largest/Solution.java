class Solution {
    public int splitArray(int[] nums, int m) {
        int low = nums[0];
        int high = 0;
        int result = 0;

        for(int n: nums){
            if(low<=n) 
                low = n;
            high+=n;
        }

        if(nums.length == m)
            return low;
        
        int mid = 0;
        
        while(low <= high) {
            if(low == high)
                return low;
            
            mid = (low + high)/2;
            
            if(splitFunction(nums, mid, m)) {
                high = mid;
                result = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;        
    }

   public boolean splitFunction(int[] nums, int mid, int m){

       int subArrCount = 1;
       int sum = 0;
       
       for(int n: nums){
           sum = sum+n;
           if(sum>mid) {
               subArrCount++;
               sum = n;
           }
           if(subArrCount > m)
               return false;
       }
       
       return true;
   }
}
