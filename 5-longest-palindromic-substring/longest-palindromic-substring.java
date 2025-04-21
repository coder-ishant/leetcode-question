class Solution {
    public static String commonSubstring(String s,int start,int end){
        while(start>=0 && end <s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start+1,end);
    }
    public String longestPalindrome(String s) {
        String longest="";
        for(int center=0;center<s.length();center++){
            int i=center;
            int j=center;
            String oddLongest=commonSubstring(s,i,j);

            if(longest.length()<oddLongest.length()){
                longest=oddLongest;
            }
            i=center;
            j = center + 1;
            String evenLongest=commonSubstring(s,i,j);
            if(longest.length()<evenLongest.length()){
                longest=evenLongest;
            }
        }
        return longest;
    }
}