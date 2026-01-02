class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        Map<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String temp = new String(arr);

            List<String> li;
            if(map.containsKey(temp))
                li = map.get(temp);
            else
                li = new ArrayList<>();
            li.add(s);
            map.put(temp,li);
        }

        for(List<String> li:map.values())
            res.add(li);



        return res;
    }
}