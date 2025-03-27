class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans=new int[2]; 
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int comp=target-nums[i];
            if(h.containsKey(comp)){
                ans[0]=i;
                ans[1]=h.get(comp);
                break;
            }
            h.put(nums[i],i);
        }
        return ans;
    }
}