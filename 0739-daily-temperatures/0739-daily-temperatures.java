class Solution {
    public int[] dailyTemperatures(int[] temps) {
        Stack<Integer> st = new Stack<>();
        int n = temps.length;
        int[] ans = new int[n];
        int pos = 0;
        for(int i=0;i<n;i++){

            while(!st.isEmpty() && temps[st.peek()]<temps[i]){
                int temp = st.pop();
                ans[temp] = i-temp;
            }

             st.push(i);
        }

        return ans;
    }
}