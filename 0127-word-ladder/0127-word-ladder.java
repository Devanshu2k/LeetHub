class Pair{
    String first;
    Integer second;

    public Pair(String first,Integer second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for(String s:wordList)
            set.add(s);
        
        if(!set.contains(endWord))
            return 0;
        q.offer(new Pair(beginWord,1));

        while(!q.isEmpty()){
            String word = q.peek().first;
            int level = q.peek().second;
            q.poll();
            for(int i=0;i<word.length();i++){
                char[] cArr = word.toCharArray();
                for(int j=0;j<26;j++){
                    cArr[i] = (char)(j+'a');
                    String temp = new String(cArr);
                    if(temp.equals(endWord)){
                        return level+1;
                    }
                    if(set.contains(temp)){
                        q.offer(new Pair(temp,level+1));
                        set.remove(temp);
                    }
                }
            }
            
        }

        return 0;
    }
}