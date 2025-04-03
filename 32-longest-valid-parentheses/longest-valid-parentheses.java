class Solution {
    public int longestValidParentheses(String s) {
        if(s.length()==0){
            return 0;
        }
        int maxLen=0,open=0,close=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                open++;
            }
            else if(c==')'){
                close++;
            }
            if(open==close){
                maxLen=Math.max(maxLen,2*close);
            }
            else if(open<close){
                open=0;
                close=0;
            }
        }
        open=0;close=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='('){
                open++;
            }
            else if(s.charAt(i)==')'){
                close++;
            }
            if(open==close){
                maxLen=Math.max(maxLen,2*close);
            }
            else if(open>close){
                open=0;
                close=0;
            }
        }
        return maxLen;
    }
}