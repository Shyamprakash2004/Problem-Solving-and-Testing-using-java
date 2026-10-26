class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        
        int m = needle.length();
        int n = haystack.length();
        int[] lps = new int[m];
        
        // Preprocess needle to create LPS array
        int len = 0;
        int i = 1;
        while (i < m) {
            if (needle.charAt(i) == needle.charAt(len)) {
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
        
        // KMP Search
        i = 0; // index for haystack
        int j = 0; // index for needle
        while (i < n) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
                i++;
            }
            if (j == m) {
                return i - j; // Found pattern at index i - j
            } else if (i < n && needle.charAt(j) != haystack.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }
}
