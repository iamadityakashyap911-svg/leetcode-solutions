import java.util.*;

class Solution {
    public List<String> commonChars(String[] words) {
        int[] common = new int[26];

        // Initialize with the first word
        for (char c : words[0].toCharArray()) {
            common[c - 'a']++;
        }

        // Find minimum frequency across all other words
        for (int i = 1; i < words.length; i++) {
            int[] count = new int[26];

            for (char c : words[i].toCharArray()) {
                count[c - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                common[j] = Math.min(common[j], count[j]);
            }
        }

        // Build answer
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            while (common[i] > 0) {
                ans.add(String.valueOf((char) ('a' + i)));
                common[i]--;
            }
        }

        return ans;
    }
}