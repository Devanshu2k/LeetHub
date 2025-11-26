class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int lo = 0;
        int n = arr.length;
        int hi = n-1;

        while(lo<hi){
            int mid = lo + (hi-lo)/2;

            if(mid<n-1 && arr[mid]<arr[mid+1]){
                lo = mid+1;
            }
            else
                hi = mid;
        }

        return lo;
    }
}