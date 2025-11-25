class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();

        int max = 0;
        int l =0;
        for(int r=0;r<arr.length;r++){
            if(set.add(arr[r])){
                max = Math.max(max,r-l+1);
            } else{
                while(arr[l]!=arr[r]){
                    set.remove(arr[l++]);
                }
                l++;
            }
        }

        return max;
    }
}