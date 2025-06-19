class Solution {
    public String longestPalindrome(String s) {
        if(s==""){
            return s;
        }
        int maxLen=1,start=0;
        int n=s.length();
        boolean[][] dp=new boolean[n][n];

        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }

        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=true;
                start=i;
                maxLen=2;
            }
        }

        for(int i=3;i<=n;i++){
            for(int j=0;j<n-i+1;j++){
                int len=i+j-1;
                if(s.charAt(j)==s.charAt(len) && dp[j+1][len-1]){
                    dp[j][len]=true;
                    if(i>maxLen){
                        start=j;
                        maxLen=i;
                    }
                }
            }
        }
        return s.substring(start,start+maxLen);
    }
}