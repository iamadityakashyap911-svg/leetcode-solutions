class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;

        // XOR of the two unique numbers
        for (int num : nums) {
            xor ^= num;
        }

        // Find a bit where the two numbers are different
        int diffBit = xor & -xor;

        int a = 0;
        int b = 0;

        // Divide numbers into two groups
        for (int num : nums) {
            if ((num & diffBit) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }
}