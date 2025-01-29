class Solution {
    public int findMin(int[] nums) {
        int s=0;
        int e=nums.length-1;
        int mid=(s+e)/2;
        while(s<e){
            mid=(s+e)/2;
            if(nums[mid]<nums[e]){
                e=mid;
            }
            else{
                s=mid+1;
            }
        }
        return nums[s];
    }
}