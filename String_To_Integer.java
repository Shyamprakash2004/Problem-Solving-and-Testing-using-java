class Solution {
    public int myAtoi(String s) {
        int index = 0, sign = 1, total = 0;
        int n = s.length();
        
        // 1. Remove leading spaces
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }
        if (index == n) return 0;
        
        // 2. Handle signs
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        
        // 3. Convert numbers and handle overflow
        while (index < n) {
            int digit = s.charAt(index) - '0';
            if (digit < 0 || digit > 9) break;
            
            // Check for overflow before multiplying by 10
            if (Integer.MAX_VALUE / 10 < total || (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            total = 10 * total + digit;
            index++;
        }
        
        return total * sign;
    }
}
