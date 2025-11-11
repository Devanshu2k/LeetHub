import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int n = intervals.length;
        List<int[]> li = new ArrayList<>();
        
        // Step 2: Add the first interval
        li.add(intervals[0]);
        
        // Step 3: Iterate over the rest
        for (int i = 1; i < n; i++) {
            int[] last = li.get(li.size() - 1);
            int[] curr = intervals[i];
            
            // Check if overlapping
            if (curr[0] <= last[1]) {
                // Merge: update end time
                last[1] = Math.max(last[1], curr[1]);
            } else {
                // No overlap → add new interval
                li.add(curr);
            }
        }
        
        // Step 4: Convert list to array
        return li.toArray(new int[li.size()][]);
    }
}
