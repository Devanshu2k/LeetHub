class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        int ans = -1;
        int n = points.length;
        for(int i=n-1;i>=0;i--){
            if(points[i][0]==x || points[i][1]==y){
                int dist = Math.abs(x-points[i][0]) + Math.abs(y-points[i][1]);
                if(dist<=min){
                    min = dist;
                    ans = i;
                }
            }
        }

        return ans;
    }
}