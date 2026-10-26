class Result {
    public static int marsExploration(String s) {
        int changedLetters = 0;
        String sos = "SOS";
        
        for (int i = 0; i < s.length(); i++) {
            // Compare character with corresponding character in "SOS" sequence
            if (s.charAt(i) != sos.charAt(i % 3)) {
                changedLetters++;
            }
        }
        
        return changedLetters;
    }
}
