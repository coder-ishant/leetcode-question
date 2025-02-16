class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        HashMap<Character,Integer> map_s2=new HashMap<>();
        for(char c:t.toCharArray()){
            map_s2.put(c,map_s2.getOrDefault(c,0)+1);
        }
        int left=0,right=0,minLen=Integer.MAX_VALUE;
        int startIndex=-1;
        int required=map_s2.size();
        int formed=0;
        HashMap<Character,Integer> windowCounts=new HashMap<>();
        while(right<s.length()){
            char rightChar=s.charAt(right);
            windowCounts.put(rightChar,windowCounts.getOrDefault(rightChar,0)+1);
            if(map_s2.containsKey(rightChar) && windowCounts.get(rightChar).intValue()==map_s2.get(rightChar).intValue()){
                formed++;
            }
            while(left<=right && formed==required){
                if(right-left+1 < minLen){
                    minLen=right-left+1;
                    startIndex=left;
                }
                char leftChar=s.charAt(left);
                windowCounts.put(leftChar,windowCounts.get(leftChar)-1);
                if(map_s2.containsKey(leftChar) && windowCounts.get(leftChar)<map_s2.get(leftChar)){
                    formed--;
                }
                left++;
            }
            right++;
        }
        return (startIndex==-1)?"":s.substring(startIndex,startIndex+minLen);
    }
}