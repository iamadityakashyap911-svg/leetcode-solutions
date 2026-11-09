class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] seen = new boolean[26];

        for (char c : allowed.toCharArray()) {
            seen[c - 'a'] = true;
        }

        int count = 0;

        for (String word : words) {
            boolean valid = true;

            for (char c : word.toCharArray()) {
                if (!seen[c - 'a']) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                count++;
            }
        }

        return count;
    }
}