class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty())
            return 0;
        Set<Character> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int left = 0;
        for(int right=0;right<s.length();right++){
            if(set.add(s.charAt(right))){
                System.out.println("if"+left);
                System.out.println("if"+right);
                max = Math.max(max,right-left+1);
            } else{
                while(s.charAt(left)!=s.charAt(right)){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(s.charAt(left));
                left++;
                set.add(s.charAt(right));
            }
           
        }

        return max;
    }
}