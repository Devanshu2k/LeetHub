class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> li = new ArrayList<>();
        if(k==0)
            return li;

        int minIdx = 0;
        int n = arr.length;
        for(int i=1;i<n;i++){
                if(Math.abs(arr[i]-x)<Math.abs(arr[minIdx]-x)){
                    minIdx = i;
                }
        }

        li.add(arr[minIdx]);
        k--;

        int left = minIdx-1;
        int right = minIdx+1;
        while(k>0){
            int dleft = Integer.MAX_VALUE;
            int dright = Integer.MAX_VALUE;
            
            if(left>=0)
                dleft = Math.abs(arr[left]-x);;
            if(right<n)
                dright = Math.abs(arr[right]-x);
            if(dleft<=dright){
                li.add(0,arr[left]);
                    left--;
                    k--;
            } else{
                 li.add(arr[right]);
                    right++;
                    k--;
            }
        }

        return li;
    }
}