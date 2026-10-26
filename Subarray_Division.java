import java.util.List;

class Result {
    public static int birthday(List<Integer> s, int d, int m) {
        int count = 0;
        
        // Loop through the list, ensuring we don't go out of bounds
        for (int i = 0; i <= s.size() - m; i++) {
            int sum = 0;
            // Sum the segment of length 'm'
            for (int j = 0; j < m; j++) {
                sum += s.get(i + j);
            }
            if (sum == d) {
                count++;
            }
        }
        
        return count;
    }
}
