class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Double.compare(getDistance(a[0], a[1]),getDistance(b[0], b[1])));

        for (int[] point : points) {
            pq.offer(point);
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            result[i] = pq.poll();
        }

        return result;
    }

    double getDistance(int x,int y){
        return Math.sqrt(x*x+y*y);
    }
}