class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] mergedArray = new int[m + n];

        int firstPointer = 0;
        int secondPointer = 0;
        int mergedPointer = 0;

        // Compare the current elements from both arrays.
        while (firstPointer < m && secondPointer < n) {
            if (nums1[firstPointer] <= nums2[secondPointer]) {
                mergedArray[mergedPointer] = nums1[firstPointer];
                firstPointer++;
            } else {
                mergedArray[mergedPointer] = nums2[secondPointer];
                secondPointer++;
            }

            mergedPointer++;
        }

        // Add the remaining elements from nums1.
        while (firstPointer < m) {
            mergedArray[mergedPointer] = nums1[firstPointer];
            firstPointer++;
            mergedPointer++;
        }

        // Add the remaining elements from nums2.
        while (secondPointer < n) {
            mergedArray[mergedPointer] = nums2[secondPointer];
            secondPointer++;
            mergedPointer++;
        }

        int totalLength = m + n;

        if (totalLength % 2 == 0) {
            int secondMid = totalLength / 2;
            int firstMid = secondMid - 1;

            return ((double) mergedArray[firstMid]
                    + mergedArray[secondMid]) / 2.0;
        } else {
            int mid = totalLength / 2;
            return mergedArray[mid];
        }
    }
}