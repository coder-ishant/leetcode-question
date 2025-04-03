class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        int index=0,result=0;
        int sign=1;
        if(s.length()==0){
            return 0;
        }
        if(s.charAt(index)=='-'){
            sign=-1;
            index++;
        }
        else if(s.charAt(index)=='+'){
            sign=1;
            index++;
        }
        while(index<s.length() && Character.isDigit(s.charAt(index))){
            int digit=s.charAt(index)-'0';
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result=result*10+digit;
            index++;
        }
        return result*sign;
        
    }
}