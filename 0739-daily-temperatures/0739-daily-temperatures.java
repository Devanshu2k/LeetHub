class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int n = temps.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

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