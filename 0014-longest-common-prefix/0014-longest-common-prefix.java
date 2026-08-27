class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;

        if(n==1)
            return strs[0];
        
        int temp = Integer.MAX_VALUE;

        for(int i=0;i<n-1;i++){
            String s1 = strs[i];
            String s2 = strs[i+1];  

            temp = Math.min(temp,s1.length());
            temp = Math.min(temp,s2.length());
            
            while(!s1.substring(0,temp).equals(s2.substring(0,temp))){
                temp--;
            }
        }

        if(temp==0)
            return "";

        return strs[0].substring(0,temp);
    }
}