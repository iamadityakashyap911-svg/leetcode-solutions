class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] rank = new int[26];

        // Store the position of each character
        for (int i = 0; i < order.length(); i++) {
            rank[order.charAt(i) - 'a'] = i;
        }

        // Check adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(words[i], words[i + 1], rank)) {
                return false;
            }
        }

        return true;
    }

    private boolean isSorted(String a, String b, int[] rank) {
        int len = Math.min(a.length(), b.length());

        for (int i = 0; i < len; i++) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);

            if (c1 != c2) {
                return rank[c1 - 'a'] < rank[c2 - 'a'];
            }
        }

        // If one is a prefix of the other,
        // shorter word must come first.
        return a.length() <= b.length();
    }
}