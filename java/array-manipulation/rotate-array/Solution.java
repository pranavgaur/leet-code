class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        if(nums.length != 1 && k != nums.length){
            reverseArray(nums, 0, nums.length-1);
            reverseArray(nums, 0, k-1);
            reverseArray(nums, k, nums.length-1);
        }
    }
    
    void reverseArray(int[] arr, int s, int e) {
        
        int start = s;
        int end = e;
        
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        
    }
}