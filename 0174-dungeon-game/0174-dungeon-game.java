class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] minHealthArray = new int[m+1][n+1];

        for(int i=0;i<m;i++)
            minHealthArray[i][n]=Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++)
            minHealthArray[m][i]=Integer.MAX_VALUE;

        minHealthArray[m-1][n]=1;
        minHealthArray[m][n-1]=1;

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                minHealthArray[i][j] = Math.max(1, Math.min(minHealthArray[i+1][j], minHealthArray[i][j+1]) - dungeon[i][j]);
            }
        }
        return minHealthArray[0][0];
    }

}