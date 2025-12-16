class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 0;
        List<int[]> li = new ArrayList<>();

        li.add(points[0]);

        for(int i=1;i<points.length;i++){
            int[] last = li.get(li.size()-1);
            int[] curr = points[i];
            if(last[1]>=curr[0]){
                last[1] = Math.min(last[1],curr[1]);
            }else{
                li.add(curr);
            }
        }

        return li.size();
    }
}
