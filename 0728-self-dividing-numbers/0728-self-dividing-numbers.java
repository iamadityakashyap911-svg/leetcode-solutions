import java.util.*;

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();

        for (int num = left; num <= right; num++) {
            if (isSelfDividing(num)) {
                ans.add(num);
            }
        }

        return ans;
    }

    private boolean isSelfDividing(int num) {
        int n = num;

        while (n > 0) {
            int digit = n % 10;

            if (digit == 0 || num % digit != 0) {
                return false;
            }

            n /= 10;
        }

        return true;
    }
}