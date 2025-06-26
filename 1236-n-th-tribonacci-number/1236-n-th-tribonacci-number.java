class Solution {
    public int tribonacci(int n) {
        int[]dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }

    int helper(int n,int[]dp){
        if(n<=1)
            return n;
        if(n==2)
            return 1;

        if(dp[n]!=-1)
            return dp[n];
               
        return dp[n] = helper(n-3,dp)+helper(n-2,dp)+helper(n-1,dp);

    }
}