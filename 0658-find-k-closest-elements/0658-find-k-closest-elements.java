class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> {
            int da = Math.abs(x-a);
            int db = Math.abs(x-b);
            if(da!=db)
                return db-da;
            return b-a;
            });
        for(int i:arr){
            pq.offer(i);
            if(pq.size()>k)
                pq.poll();
        }

        List<Integer> li = new ArrayList<>();
        while(!pq.isEmpty())
            li.add(pq.poll());
        Collections.sort(li);
        return li;
    }
}