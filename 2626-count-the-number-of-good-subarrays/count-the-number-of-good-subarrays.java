import java.util.HashMap;

class Solution {
    public long countGood(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        long res = 0;
        long pairCount = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int current = nums[right];
            int freq = freqMap.getOrDefault(current, 0);
            pairCount += freq; // Each existing frequency contributes to a pair
            freqMap.put(current, freq + 1);

            while (pairCount >= k) {
                res += nums.length - right; // All subarrays from [left..right] to [left..end] are valid
                int leftFreq = freqMap.get(nums[left]);
                pairCount -= (leftFreq - 1); // Remove effect of nums[left]
                if (leftFreq == 1) {
                    freqMap.remove(nums[left]);
                } else {
                    freqMap.put(nums[left], leftFreq - 1);
                }
                left++;
            }
        }

        return res;
    }
}
