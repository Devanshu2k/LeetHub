class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i:nums)
            set.add(i);
        
        int max = 0;
        for(int i:set){
            if(set.contains(i-1))
                continue;
            int temp = i;
            int count = 1;
            while(set.contains(temp+1)){
                count++;
                temp++;
            }
             max = Math.max(max,count);
        }

        return max;
    }
}