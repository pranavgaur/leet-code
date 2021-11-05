class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        int idx1 = 0;
        int idx2 = 0;
        
        boolean even = false;
        
        double median = 0;
        
        if ((len1+len2)%2 == 0) {
            even = true;
            idx1 = ((len1+len2)/2) - 1; 
            idx2 = idx1+1;
        } else {
            idx1 = (len1+len2+1)/2 - 1;
            idx2 = idx1;
        }
        
        int i = 0, j = 0, k = 0;
        
        while(i < len1 && j < len2){
            if(nums1[i] <= nums2[j]){
                i++;
                k++;
                if(even){
                    if(k-1 == idx1 || k-1 == idx2)
                        median+=nums1[i-1];
                } else {
                    if(k-1 == idx1)
                        median+=2*nums1[i-1];
                }
            } else {
                j++;
                k++;
                if(even){
                    if(k-1 == idx1 || k-1 == idx2)
                        median+=nums2[j-1];
                } else {
                    if(k-1 == idx1)
                        median+=2*nums2[j-1];
                }
            }
        }
        
        while(i < len1){
            
            i++;
            k++;
            if(even){
                if(k-1 == idx1 || k-1 == idx2)
                    median+=nums1[i-1];
            } else {
                if(k-1 == idx1)
                    median+=2*nums1[i-1];
            }
            
        }
        
        while(j < len2) {
            j++;
            k++;
            if(even){
                if(k-1 == idx1 || k-1 == idx2)
                    median+=nums2[j-1];
            } else {
                if(k-1 == idx1)
                    median+=2*nums2[j-1];
            }
            
        }
        
        return median/2;
        
    }
}