class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int i=0;i<word1.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return dfs(0,0,word1,word2,dp);
    }

    int dfs(int i,int j, String word1,String word2,int[][]dp){
        if(j==word2.length()){
            return word1.length()-i;
        }
        if(i==word1.length()){
            return word2.length()-j;
        }

        if(dp[i][j]!=-1)
            return dp[i][j];

        if(word1.charAt(i)==word2.charAt(j)){
            return dp[i][j]=dfs(i+1,j+1,word1,word2,dp);
        }
        
        int add = 1+dfs(i,j+1,word1,word2,dp);
        int remove = 1+dfs(i+1,j,word1,word2,dp);
        int replace = 1+dfs(i+1,j+1,word1,word2,dp);
        

        return dp[i][j]=Math.min(add,Math.min(remove,replace));
    }
}