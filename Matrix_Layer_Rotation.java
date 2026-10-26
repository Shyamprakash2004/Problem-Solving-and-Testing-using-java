import java.util.List;
import java.util.ArrayList;

class Result {
    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int layers = Math.min(m, n) / 2;
        
        for (int layer = 0; layer < layers; layer++) {
            List<Integer> elements = new ArrayList<>();
            
            // Extract 1D array of the layer
            for (int j = layer; j < n - layer; j++) elements.add(matrix.get(layer).get(j));
            for (int i = layer + 1; i < m - layer - 1; i++) elements.add(matrix.get(i).get(n - layer - 1));
            for (int j = n - layer - 1; j >= layer; j--) elements.add(matrix.get(m - layer - 1).get(j));
            for (int i = m - layer - 2; i > layer; i--) elements.add(matrix.get(i).get(layer));
            
            int k = r % elements.size();
            int idx = 0;
            int total = elements.size();
            
            // Insert rotated elements back into matrix
            for (int j = layer; j < n - layer; j++) 
                matrix.get(layer).set(j, elements.get((idx++ + k) % total));
            for (int i = layer + 1; i < m - layer - 1; i++) 
                matrix.get(i).set(n - layer - 1, elements.get((idx++ + k) % total));
            for (int j = n - layer - 1; j >= layer; j--) 
                matrix.get(m - layer - 1).set(j, elements.get((idx++ + k) % total));
            for (int i = m - layer - 2; i > layer; i--) 
                matrix.get(i).set(layer, elements.get((idx++ + k) % total));
        }
        
        for (List<Integer> row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
