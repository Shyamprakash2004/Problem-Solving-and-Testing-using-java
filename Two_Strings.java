import java.util.HashSet;
import java.util.Set;

class Result {
    public static String twoStrings(String s1, String s2) {
        // If two strings share a common substring, they must share at least one common character.
        Set<Character> set1 = new HashSet<>();
        
        for (char c : s1.toCharArray()) {
            set1.add(c);
        }
        
        for (char c : s2.toCharArray()) {
            if (set1.contains(c)) {
                return "YES";
            }
        }
        
        return "NO";
    }
}
