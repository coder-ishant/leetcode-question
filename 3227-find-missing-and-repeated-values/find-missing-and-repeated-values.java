class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] count=new int[grid.length * grid.length + 1];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                count[grid[i][j]]++;
            }
        }
        int[] arr=new int[2];
        int repeat=0,mis=0;
        for(int i=1;i<count.length;i++){
            if(count[i]>=2){
                repeat=i;
            }
            if(count[i]==0){
                mis=i;
            }
        }
        arr[0]=repeat;
        arr[1]=mis;
       
        return arr;
    }
}