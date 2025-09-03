class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();

        int[] current = intervals[0];

        for(int i=1;i<intervals.length;i++){
            if(current[1]>=intervals[i][0]){
                current[1] = Math.max(current[1],intervals[i][1]);
            }
            else{
                merged.add(current);
                current = intervals[i];
            }
        }
        
        merged.add(current);
        // Step 4: Convert List back to array
        return merged.toArray(new int[merged.size()][]);
    }
}