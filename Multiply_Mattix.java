class Solution {
    static int[][] multiplyMatrix(int n1, int m1, int n2, int m2, int arr1[][], int arr2[][]) {
        if (m1 != n2) {
            return new int[0][0]; 
        }
        
        int[][] res = new int[n1][m2];
        
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {
                for (int k = 0; k < m1; k++) {
                    res[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return res;
    }
}
