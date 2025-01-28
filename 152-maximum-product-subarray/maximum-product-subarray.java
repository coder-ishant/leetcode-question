public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxProduct = Integer.MIN_VALUE;
        int product = 1;

        // Forward pass: Calculate product from left to right
        for (int num : nums) {
            product *= num;
            maxProduct = Math.max(maxProduct, product);

            // Reset the product if it becomes zero (invalid subarray)
            if (product == 0) {
                product = 1;
            }
        }

        product = 1; // Reset for backward pass

        // Backward pass: Calculate product from right to left
        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            maxProduct = Math.max(maxProduct, product);

            // Reset the product if it becomes zero
            if (product == 0) {
                product = 1;
            }
        }

        return maxProduct;
    }
}
