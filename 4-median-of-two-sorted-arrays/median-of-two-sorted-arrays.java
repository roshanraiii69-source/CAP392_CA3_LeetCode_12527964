class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int totalLen = m + n;
        
        int i = 0, j = 0;
        int curr = 0, prev = 0;
        
        
        for (int count = 0; count <= totalLen / 2; count++) {
            prev = curr;
            if (i < m && (j >= n || nums1[i] <= nums2[j])) {
                curr = nums1[i];
                i++;
            } else {
                curr = nums2[j];
                j++;
            }
        }
        
        
        if (totalLen % 2 == 0) {
            return (double) (prev + curr) / 2.0;
        } else {
            
            return (double) curr;
        }
    }
}