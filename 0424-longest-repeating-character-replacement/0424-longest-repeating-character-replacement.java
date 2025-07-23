class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int maxFreq = 0;
        int[] chars = new int[26];

        char[] arr = s.toCharArray();
        int n = arr.length;

        int j=0;
        for(int i=0;i<n;i++){
            chars[arr[i]-'A']++;
            maxFreq = Math.max(maxFreq,chars[arr[i]-'A']);
            if(((i-j+1)-maxFreq)>k){
                chars[arr[j]-'A']--;
                j++;
            }
             max = Math.max(max, i - j + 1);
        }

        return max;
    }
}