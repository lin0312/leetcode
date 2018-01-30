class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j >= 0; j--) {
                if(j == i) {
                    dp[j][i] = 1;
                } else if(s.charAt(j) == s.charAt(i)){
                    dp[j][i] = dp[j + 1][i - 1] + 2;
                } else {
                    dp[j][i] = Math.max(dp[j + 1][i], dp[j][i - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
