class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int end1 = m-1;
        int end2 = n-1;
        int end = m+n-1;
        
        while(end1 >= 0 && end2 >= 0){
            if(nums2[end2] > nums1[end1])
                nums1[end--]=nums2[end2--];
            else
                nums1[end--]=nums1[end1--];
        }
        
        while(end1 >= 0){
            nums1[end--]=nums1[end1--];
        }

        while(end2 >= 0){
            nums1[end--]=nums2[end2--];
        }
    }
}