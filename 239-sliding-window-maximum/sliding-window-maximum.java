class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int i=0,j=0;
        Deque<Integer> dq=new ArrayDeque<>();
        ArrayList<Integer> list=new ArrayList<>();
        while(j<n){
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[j]) {
                dq.pollLast();
            }

            dq.offerLast(j);

            // Remove front if it's outside the window
            if (dq.peekFirst() < i) {
                dq.pollFirst();
            }
            
            if (j - i + 1 == k) {
                list.add(nums[dq.peekFirst()]);
                i++;
            }
            j++;
        }
        int[] ans = new int[list.size()];
        for (int l = 0; l < list.size(); l++) {
            ans[l] = list.get(l);
        }
        return ans;
    }
}