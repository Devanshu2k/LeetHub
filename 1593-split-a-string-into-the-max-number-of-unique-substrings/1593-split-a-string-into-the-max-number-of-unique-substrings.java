class Solution {
   int max = Integer.MIN_VALUE;

    public int maxUniqueSplit(String s) {
       helper(s,0,new HashSet<>());
       return max;
    }

    void helper(String s,int left,Set<String> set){
        if(left>=s.length()){
            max = Math.max(max,set.size());
            return;
        }
   
        for(int right=left+1;right<=s.length();right++){
            String temp = s.substring(left,right);
            if(set.contains(temp)){
                continue;
            }
            else{
                set.add(temp);
                helper(s,right,set);
                set.remove(temp);
            }
        }
    }
}