class Solution {
    public String[] findRelativeRanks(int[] score) {

        int n = score.length;
        String[] ans = new String[n];

        // Create Integer array of indices
        Integer[] index = new Integer[n];

        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        // Sort indices according to scores (highest first)
        Arrays.sort(index, (a, b) -> score[b] - score[a]);

        // Assign ranks
        for (int i = 0; i < n; i++) {

            int originalIndex = index[i];

            if (i == 0)
                ans[originalIndex] = "Gold Medal";
            else if (i == 1)
                ans[originalIndex] = "Silver Medal";
            else if (i == 2)
                ans[originalIndex] = "Bronze Medal";
            else
                ans[originalIndex] = String.valueOf(i + 1);
        }

        return ans;
    }
}
