import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }
        
        return result;
    }
    
    private boolean matches(String word, String pattern) {
        int[] map1 = new int[256];
        int[] map2 = new int[256];
        
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            
            if (map1[w] != map2[p]) return false;
            
            // Use (i + 1) to distinguish from default 0 values
            map1[w] = i + 1;
            map2[p] = i + 1;
        }
        return true;
    }
}
