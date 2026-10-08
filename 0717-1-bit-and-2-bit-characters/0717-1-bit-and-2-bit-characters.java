class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;

        while (i < bits.length - 1) {
            if (bits[i] == 1) {
                i += 2;  // 2-bit character: 10 or 11
            } else {
                i += 1;  // 1-bit character: 0
            }
        }

        return i == bits.length - 1;
    }
}