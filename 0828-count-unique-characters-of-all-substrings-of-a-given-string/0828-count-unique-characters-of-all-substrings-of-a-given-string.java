class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();
        int[] prev = new int[n];
        int[] next = new int[n];

        int[] last = new int[26];
        Arrays.fill(last, -1);

        // prev[i] = previous occurrence of s[i]
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'A';
            prev[i] = last[c];
            last[c] = i;
        }

        Arrays.fill(last, n);

        // next[i] = next occurrence of s[i]
        for (int i = n - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'A';
            next[i] = last[c];
            last[c] = i;
        }

        long ans = 0;

        // contribution of each character
        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;
            ans += left * right;
        }

        return (int) ans;
    }
}
