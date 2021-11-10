class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int low = weights[0];
        int high = 0;
        int result = 0;

        for(int n: weights){
            if(low<=n) 
                low = n;
            high+=n;
        }

        if(weights.length == days)
            return low;
        
        int mid = 0;
        
        while(low <= high) {
            if(low == high)
                return low;
            
            mid = (low + high)/2;
            
            if(splitFunction(weights, mid, days)) {
                high = mid;
                result = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low; 
        
    }
    
      public boolean splitFunction(int[] weights, int mid, int days){

       int subArrCount = 1;
       int sum = 0;
       
       for(int n: weights){
           sum = sum+n;
           if(sum>mid) {
               subArrCount++;
               sum = n;
           }
           if(subArrCount > days)
               return false;
       }
       
       return true;
   }
}