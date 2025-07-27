class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;

        int[][] combined = new int[n][2];

        for(int i=0;i<n;i++){
            combined[i][0] = position[i];
            combined[i][1] = speed[i];
        }

        Arrays.sort(combined, (a, b) -> Integer.compare(b[0], a[0]));

        Stack<Float> st = new Stack<>();

        for(int i=0;i<n;i++){
            float temp = (target-combined[i][0])/(float)combined[i][1];
            if(!st.isEmpty() && st.peek()>=temp){
                continue;
            }

            st.push(temp);
        }

        return st.size();
    }
}