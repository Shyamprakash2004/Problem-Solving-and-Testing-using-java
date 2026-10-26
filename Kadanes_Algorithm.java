import java.util.List;
import java.util.ArrayList;

class Result {
    public static List<Integer> maxSubarray(List<Integer> arr) {
        int maxSubarraySum = arr.get(0);
        int currentSum = arr.get(0);
        int maxSubsequenceSum = arr.get(0);
        
        // Traverse to find both max subarray (Kadane's) and max subsequence
        for (int i = 1; i < arr.size(); i++) {
            int num = arr.get(i);
            
            // Kadane's Algorithm for contiguous subarray
            currentSum = Math.max(num, currentSum + num);
            maxSubarraySum = Math.max(maxSubarraySum, currentSum);
            
            // Subsequence sum (ignore negatives unless all are negative)
            if (maxSubsequenceSum < 0) {
                maxSubsequenceSum = Math.max(maxSubsequenceSum, num);
            } else if (num > 0) {
                maxSubsequenceSum += num;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        result.add(maxSubarraySum);
        result.add(maxSubsequenceSum);
        return result;
    }
}
