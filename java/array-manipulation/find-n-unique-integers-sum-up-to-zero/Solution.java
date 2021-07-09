class Solution {
    public int[] sumZero(int n) {
        
        int[] resArray = new int[n];
        int target = 0;
        int counter = 1;
        for(int i = 0; i < n; i++){
            if(i == n-1){
                resArray[i] = 0-target;
            } else{
                resArray[i] = counter;
                target = target + counter;
                counter++;
            }
        }
        
        return resArray;
        
    }
}