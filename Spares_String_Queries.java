import java.util.*;

public class SparseArrays {
    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        Map<String, Integer> stringCount = new HashMap<>();
        
        // Pre-compute frequencies to avoid scanning collection for each query (O(N) setup)
        for (String s : strings) {
            stringCount.put(s, stringCount.getOrDefault(s, 0) + 1);
        }
        
        List<Integer> results = new ArrayList<>();
        // O(1) lookup per query
        for (String q : queries) {
            results.add(stringCount.getOrDefault(q, 0));
        }
        
        return results;
    }
}
