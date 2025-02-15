class Solution {
    public int lengthOfLongestSubstring(String s) {
       /* if(s.isEmpty()){
            return 0;
        }*/
        int n = s.length();
        int st = 0, currlen = 0, maxlen = 0;
        HashMap<Character, Integer> pos = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (pos.containsKey(s.charAt(i)) && pos.get(s.charAt(i)) >= st) {
                maxlen = Math.max(maxlen, i - st);
                st = pos.get(s.charAt(i)) + 1;
            }
            pos.put(s.charAt(i), i);
        }
        return Math.max(maxlen, n - st);
        
    }
}