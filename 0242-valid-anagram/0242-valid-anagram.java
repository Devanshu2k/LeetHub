class Solution {
    public boolean isAnagram(String str1, String str2) {
        if(str1.length()!=str2.length())
            return false;
        int n = str1.length();
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        
        Arrays.sort(s1);
        Arrays.sort(s2);

        
        for(int i=0;i<n;i++)
            if(s1[i]!=s2[i])
                return false;

        return true;
    }
}