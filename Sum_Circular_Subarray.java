class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int currMax = 0, maxSum = nums[0];
        int currMin = 0, minSum = nums[0];
        
        for (int num : nums) {
            // Standard Kadane's for max subarray
            currMax = Math.max(currMax + num, num);
            maxSum = Math.max(maxSum, currMax);
            
            // Kadane's for min subarray (to find max wrapped around)
            currMin = Math.min(currMin + num, num);
            minSum = Math.min(minSum, currMin);
            
            totalSum += num;
        }
        
        // If all numbers are negative, maxSum is the max element (no wrap around possible)
        if (maxSum > 0) {
            return Math.max(maxSum, totalSum - minSum);
        }
        return maxSum;
    }
}
