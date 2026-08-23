class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        
        int i = 0;
        int n = arr.length;

        // Walk up to the peak
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }

        // Peak cannot be the first or last element
        if (i == 0 || i == n - 1) {
            return false;
        }

        // Walk down from the peak
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        // Check if we reached the end of the array
        return i == n - 1;
    }
}
