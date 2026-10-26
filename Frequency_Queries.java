import java.util.*;

public class FrequencyQueries {
    public static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> valueToFreq = new HashMap<>();
        Map<Integer, Integer> freqOfFreqs = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (List<Integer> query : queries) {
            int type = query.get(0);
            int val = query.get(1);

            if (type == 1) { // Insert
                int oldFreq = valueToFreq.getOrDefault(val, 0);
                int newFreq = oldFreq + 1;
                valueToFreq.put(val, newFreq);
                
                if (oldFreq > 0) {
                    freqOfFreqs.put(oldFreq, freqOfFreqs.get(oldFreq) - 1);
                }
                freqOfFreqs.put(newFreq, freqOfFreqs.getOrDefault(newFreq, 0) + 1);
                
            } else if (type == 2) { // Delete one occurrence
                int oldFreq = valueToFreq.getOrDefault(val, 0);
                if (oldFreq > 0) {
                    int newFreq = oldFreq - 1;
                    valueToFreq.put(val, newFreq);
                    
                    freqOfFreqs.put(oldFreq, freqOfFreqs.get(oldFreq) - 1);
                    if (newFreq > 0) {
                        freqOfFreqs.put(newFreq, freqOfFreqs.getOrDefault(newFreq, 0) + 1);
                    }
                }
                
            } else if (type == 3) { // Check frequency
                if (val > queries.size()) {
                    result.add(0); // Optimization: frequency can't exceed number of ops
                } else {
                    result.add(freqOfFreqs.getOrDefault(val, 0) > 0 ? 1 : 0);
                }
            }
        }
        return result;
    }
}
