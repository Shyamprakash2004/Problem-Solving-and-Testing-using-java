public class RichestCustomerWealth {
    public static int maximumWealth(int[][] accounts) {
        int max = 0;

        for (int[] account : accounts) {
            int wealth = 0;
            for (int money : account) {
                wealth += money;
            }
            max = Math.max(max, wealth);
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] accounts = {
            {1, 2, 3},
            {3, 2, 1}
        };

        System.out.println(maximumWealth(accounts));
    }
}
