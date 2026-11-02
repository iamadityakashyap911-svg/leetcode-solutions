import java.util.*;

class Solution {
    Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) return new ArrayList<>();

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        List<TreeNode> result = new ArrayList<>();

        if (n == 1) {
            result.add(new TreeNode(0));
            return result;
        }

        for (int left = 1; left < n; left += 2) {
            int right = n - 1 - left;

            List<TreeNode> leftTrees = allPossibleFBT(left);
            List<TreeNode> rightTrees = allPossibleFBT(right);

            for (TreeNode l : leftTrees) {
                for (TreeNode r : rightTrees) {
                    result.add(new TreeNode(0, l, r));
                }
            }
        }

        memo.put(n, result);
        return result;
    }
}