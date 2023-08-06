public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // Create a 2D array to store the edit distances for substrings of word1 and word2.
        int[][] dp = new int[m + 1][n + 1];
        
        // Initialize the first row and first column of the dp array.
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        
        // Fill in the dp array using dynamic programming.
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        
        // The final result is stored in the bottom-right cell of the dp array.
        return dp[m][n];
    }
    
    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        String s = "horse";
        String t = "ros";
        int minOperations = editDistance.minDistance(s, t);
        System.out.println("Minimum number of operations required: " + minOperations);
    }
}

