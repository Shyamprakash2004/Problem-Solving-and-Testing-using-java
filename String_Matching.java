import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        
        // Sort strings by length, shortest first
        Arrays.sort(words, Comparator.comparingInt(String::length));
        
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                // If the shorter word is a substring of the longer one
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                    break; // Move to the next string in the outer loop
                }
            }
        }
        
        return result;
    }
}
