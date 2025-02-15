class Solution {
    public static String reverseString(String str){
        return new StringBuilder(str).reverse().toString();
    }
    public String finalString(String s) {
        String str="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='i'){
                str=reverseString(str);
            }
            else{
                str+=s.charAt(i);
            }

        }
        return str;
    }
}