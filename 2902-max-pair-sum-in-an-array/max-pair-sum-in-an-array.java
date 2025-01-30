class Solution {
    public static int largestDigit(int num){
        int a=num;
        int maxDig=0;
        while(a>0){
            int rem=a%10;
            maxDig=Math.max(maxDig,rem);
            a=a/10;
        }
        return maxDig;
    }
    public int maxSum(int[] nums) {
        HashMap<Integer,List<Integer>> h=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int lg=largestDigit(nums[i]);
            h.putIfAbsent(lg,new ArrayList<>());
            h.get(lg).add(nums[i]);
        }
        int maxSum = -1;
        
        // Iterate through each group to find max pair sum
        for (List<Integer> group : h.values()) {
            if (group.size() > 1) {
                Collections.sort(group, Collections.reverseOrder());
                maxSum = Math.max(maxSum, group.get(0) + group.get(1));
            }
        }
        
        return maxSum;
    }
    
}