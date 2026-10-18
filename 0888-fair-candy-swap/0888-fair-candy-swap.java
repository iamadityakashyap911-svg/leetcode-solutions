import java.util.*;

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0;
        int sumB = 0;

        for (int x : aliceSizes) {
            sumA += x;
        }

        for (int x : bobSizes) {
            sumB += x;
        }

        int diff = (sumA - sumB) / 2;

        HashSet<Integer> set = new HashSet<>();

        for (int x : aliceSizes) {
            set.add(x);
        }

        for (int y : bobSizes) {
            int x = y + diff;

            if (set.contains(x)) {
                return new int[]{x, y};
            }
        }

        return new int[0];
    }
}