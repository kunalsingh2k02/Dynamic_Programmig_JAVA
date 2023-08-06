public class SubsetSum {

    // Function to check if there is a subset with the given sum
    static int isSubsetSum(int[] arr, int N, int sum) {
        // dp[i][j] will be true if there is a subset of elements up to index i in arr[]
        // with a sum equal to j.
        boolean[][] dp = new boolean[N + 1][sum + 1];

        // If sum is 0, then answer is true, as there's an empty subset that sums to 0.
        for (int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }

        // Fill the dp[][] table
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                // If the current element is greater than the sum, we cannot include it in the subset
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Check if the sum can be achieved by either including the current element or excluding it
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        // The result will be stored in dp[N][sum]
        return dp[N][sum] ? 1 : 0;
    }

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int N = arr.length;
        int sum = 9;

        int result = isSubsetSum(arr, N, sum);
        System.out.println("Output: " + result);
    }
}

