import java.util.*;

class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> subarray = new ArrayList<>();
            int count = 0;

            for (int j = i; j < nums.length; j++) {
                subarray.add(nums[j]);

                if (nums[j] % p == 0) {
                    count++;
                }

                if (count <= k) {
                    set.add(new ArrayList<>(subarray));
                } else {
                    break;
                }
            }
        }

        return set.size();
    }
}