class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length==0 || arr.length==1 || arr.length==2){
            return false;
        }
        for(int i=2;i<arr.length;i++){
            if(arr[i-1]%2!=0 && arr[i-2]%2!=0 && arr[i]%2!=0){
                return true;
            }
        }
        return false;
    }
}