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
            else if(nums[mid]>nums[e]){
                s=mid+1;
            }
            else{
                e--;
            }
        }
        return nums[s];
    }
}