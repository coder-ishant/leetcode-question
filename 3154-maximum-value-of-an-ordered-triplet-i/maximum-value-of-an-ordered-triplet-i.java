class Solution {
    public long maximumTripletValue(int[] nums) {
        long triplet=0, n = nums.length;
         
        for(int i=0;i<n;i++){
            for(int j=i+1; j<n; j++){
                for(int k = j+1; k<n; k++){
                    long val = (nums[i] - nums[j]);
                    val = val*nums[k];
                    triplet = Math.max(triplet, val);
                }
            }
        }
        if(triplet<0){
            return 0;
        }
        return triplet;
    }
}