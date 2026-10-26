class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        
        // Transform S into T.
        // For example, S = "abba", T = "^#a#b#b#a#$"
        // ^ and $ signs are sentinels appended to each end to avoid bounds checking
        StringBuilder t = new StringBuilder("^");
        for (int i = 0; i < s.length(); i++) {
            t.append("#").append(s.charAt(i));
        }
        t.append("#$");
        
        int n = t.length();
        int[] p = new int[n]; // Array to store palindrome lengths
        int center = 0, right = 0;
        
        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i; // equals to center - (i - center)
            
            if (right > i) {
                p[i] = Math.min(right - i, p[mirror]);
            }
            
            // Expand palindrome centered at i
            while (t.charAt(i + 1 + p[i]) == t.charAt(i - 1 - p[i])) {
                p[i]++;
            }
            
            // Adjust center if expanded palindrome reaches beyond right bound
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }
        
        // Find the maximum element in p
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }
        
        int start = (centerIndex - 1 - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
}
