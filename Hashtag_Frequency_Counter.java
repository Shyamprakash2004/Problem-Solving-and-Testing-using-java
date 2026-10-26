import java.util.*;

public class HashtagCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        Map<String, Integer> freqMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String tag = sc.next();
            freqMap.put(tag, freqMap.getOrDefault(tag, 0) + 1);
        }
        sc.close();
        
        // PriorityQueue to sort by frequency (descending) and then lexicographically
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a, b) -> {
                if (!a.getValue().equals(b.getValue())) {
                    return b.getValue() - a.getValue();
                }
                return a.getKey().compareTo(b.getKey());
            }
        );
        
        pq.addAll(freqMap.entrySet());
        
        while (!pq.isEmpty()) {
            Map.Entry<String, Integer> entry = pq.poll();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
