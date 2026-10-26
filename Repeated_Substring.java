class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;
        
        // Compute KMP LPS (Longest Prefix Suffix) array
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        int longestLps = lps[n - 1];
        // If there's a repeating pattern, the length of the string must be perfectly 
        // divisible by the length of the repeating unit
        return longestLps > 0 && n % (n - longestLps) == 0;
    }
}
