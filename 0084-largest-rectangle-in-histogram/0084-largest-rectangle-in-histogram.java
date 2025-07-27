class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        Stack<Integer> st = new Stack<>();
        int[] left= new int[n];
        int[] right = new int[n];
        int max = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
           while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int temp = st.pop();
                right[temp] = i-temp-1;
           }

           st.push(i);
        }

        while(!st.isEmpty()){
            int temp = st.pop();
            right[temp] = n-temp-1;
        }

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int temp = st.pop();
                left[temp] = temp-i-1;
           }

           st.push(i);
        }

        while(!st.isEmpty()){
            int temp = st.pop();
            left[temp] = temp;
        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        for(int i=0;i<n;i++){
            max = Math.max(max,heights[i]*(left[i]+right[i]+1));
        }
        return max;
    }
}