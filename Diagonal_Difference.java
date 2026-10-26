import java.util.List;

class Result {
    public static int diagonalDifference(List<List<Integer>> arr) {
        int n = arr.size();
        int primaryDiag = 0;
        int secondaryDiag = 0;
        
        for (int i = 0; i < n; i++) {
            primaryDiag += arr.get(i).get(i);
            secondaryDiag += arr.get(i).get(n - 1 - i);
        }
        
        return Math.abs(primaryDiag - secondaryDiag);
    }
}
