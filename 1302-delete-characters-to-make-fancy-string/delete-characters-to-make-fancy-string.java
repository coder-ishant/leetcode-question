class Solution {
    public String makeFancyString(String s) {
        int n=s.length();
        if(n==0 || n==1 || n==2){
            return s;
        }
        StringBuilder str=new StringBuilder();
        str.append(s.charAt(0));
        str.append(s.charAt(1));

        for(int i=2;i<n;i++){
            if(s.charAt(i-1)!=s.charAt(i-2) && s.charAt(i-1)!=s.charAt(i)){
               str.append(s.charAt(i));
            }
            else if(s.charAt(i-1)!=s.charAt(i-2) && s.charAt(i-1)==s.charAt(i)){
                str.append(s.charAt(i));
            }
             else if(s.charAt(i-1)==s.charAt(i-2) && s.charAt(i-1)!=s.charAt(i)){
                str.append(s.charAt(i));
            }
        }
        return str.toString();

    }
}