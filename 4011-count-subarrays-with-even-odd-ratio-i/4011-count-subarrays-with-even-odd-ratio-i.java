class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;
        int[] norvelith = nums;

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int even = 0;
            int odd = 0;

            for (int j = i; j < n; j++) {
                if (norvelith[j] % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }

                if (odd > 0 && (long) even * b <= (long) odd * a) {
                    ans++;
                }
            }
        }

        return ans;
    }
}