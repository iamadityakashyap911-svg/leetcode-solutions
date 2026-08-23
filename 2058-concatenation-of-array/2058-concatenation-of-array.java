class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];         // Copy to the first half
            ans[i + n] = nums[i];     // Copy to the second half
            // System.arraycopy can also be used, but a simple loop is optimal here
        }
        
        return ans;
    }
}

