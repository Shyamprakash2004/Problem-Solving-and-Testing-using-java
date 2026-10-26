import java.util.*;

public class SmartTraffic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
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

    private static boolean hasRoute(Map<Integer, List<Integer>> graph, int src, int dest, int n) {
        if (src == dest) return true;
        
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(src);
        visited[src] = true;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int neighbor : graph.getOrDefault(curr, new ArrayList<>())) {
                if (neighbor == dest) return true;
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }
}
