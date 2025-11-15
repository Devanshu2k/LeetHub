class Solution {
    public int climbStairs(int n) {
        int[] arr  = new int[n+1];
        Arrays.fill(arr,-1);
        return ans(n,arr);
    }

    public int ans(int n,int[] arr){
        if(arr[n]!=-1)
            return arr[n];
        
        if(n==1||n==2||n==3)
            return n;
        
        arr[n] = ans(n-1,arr)+ans(n-2,arr);

        return arr[n];
    }
}