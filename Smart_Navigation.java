import java.util.*;

public class SmartTrafficGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        // Nested Collection: Map containing Sets
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
        }
        
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u); 
        }
        
        int src = sc.nextInt();
        int dest = sc.nextInt();
        sc.close();
        
        System.out.println(hasRoute(graph, src, dest, n) ? "YES" : "NO");
    }

    private static boolean hasRoute(Map<Integer, Set<Integer>> graph, int src, int dest, int n) {
        if (src == dest) return true;
        
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited.add(src);
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int neighbor : graph.getOrDefault(curr, new HashSet<>())) {
                if (neighbor == dest) return true;
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }
}
