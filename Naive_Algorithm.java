class Solution {
    // Function to search for pattern in text
    static void search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        
        // A loop to slide pat one by one
        for (int i = 0; i <= N - M; i++) {
            int j;
            
            // For current index i, check for pattern match
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            
            // If pat[0...M-1] = txt[i, i+1, ...i+M-1]
            if (j == M) {
                System.out.println("Pattern found at index " + i);
            }
        }
    }

    public static void main(String[] args) {
        String txt = "AABAACAADAABAABA";
        String pat = "AABA";
        search(pat, txt);
    }
}
