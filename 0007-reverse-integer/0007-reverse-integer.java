class Solution {
    public int reverse(int x) {
        
        boolean neg = false;
        if(x<0){
            x*=-1;
            neg = true;
        }
        int temp = x;
        long reverse=0;
        while(temp>0){
            reverse = reverse*10 + (temp%10);
            temp/=10;
        }
        if(reverse>Integer.MAX_VALUE || reverse<Integer.MIN_VALUE)
           return 0;
        
        return neg?-1*(int)reverse:(int)reverse;
    }
}