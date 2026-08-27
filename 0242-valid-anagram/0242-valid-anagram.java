class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        
        Map<Character,Integer> smap = new HashMap<>();
        Map<Character,Integer> tmap = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            smap.put(c,smap.getOrDefault(c,0)+1);
            c = t.charAt(i);
            tmap.put(c,tmap.getOrDefault(c,0)+1);
        }

        for(char k:smap.keySet()){
            if(!tmap.containsKey(k) || !tmap.get(k).equals(smap.get(k)))
                return false;
        }
        return true;
    }
}