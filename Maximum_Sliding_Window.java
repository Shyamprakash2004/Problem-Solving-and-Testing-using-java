import java.util.*;

public class MaxDistinctSlidingWindow {
    public static int maxDistinct(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxDistinct = 0;
        
        // Initialize the first window
        for (int i = 0; i < k && i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        maxDistinct = map.size();
        
        // Slide the window
        for (int i = k; i < arr.length; i++) {
            // Remove the element going out of the window
            int outElement = arr[i - k];
            map.put(outElement, map.get(outElement) - 1);
            if (map.get(outElement) == 0) {
                map.remove(outElement);
            }
            
            // Add the new element coming into the window
            int inElement = arr[i];
            map.put(inElement, map.getOrDefault(inElement, 0) + 1);
            
            maxDistinct = Math.max(maxDistinct, map.size());
        }
        
        return maxDistinct;
    }
}
