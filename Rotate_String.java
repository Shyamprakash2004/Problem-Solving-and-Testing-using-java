class Solution {
    public boolean rotateString(String s, String goal) {
        // If lengths don't match, they can't be rotations
        if (s.length() != goal.length()) {
            return false;
        }
        
        // A rotated string is always a substring of the original string concatenated with itself
        String doubledString = s + s;
        return doubledString.contains(goal);
    }
}
