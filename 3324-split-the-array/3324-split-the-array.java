class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        // Since constraints guarantee 1 <= nums[i] <= 100
        int[] counts = new int[101];
        
        for (int num : nums) {
            counts[num]++;
            
            // If any number shows up 3 or more times, splitting perfectly is impossible
            if (counts[num] > 2) {
                return false;
            }
        }
        
        return true;
    }
}
