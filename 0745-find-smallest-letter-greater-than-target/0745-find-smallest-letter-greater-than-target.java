class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int lo = 0, hi = n - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (letters[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        // lo is now the first index where letters[lo] > target
        return lo == n ? letters[0] : letters[lo];
    }
}
