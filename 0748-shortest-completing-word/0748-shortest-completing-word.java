class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] required = new int[26];

        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                required[c - 'a']++;
            }
        }

        String answer = null;

        for (String word : words) {
            int[] freq = new int[26];

            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }

            boolean complete = true;

            for (int i = 0; i < 26; i++) {
                if (freq[i] < required[i]) {
                    complete = false;
                    break;
                }
            }

            if (complete && (answer == null || word.length() < answer.length())) {
                answer = word;
            }
        }

        return answer;
    }
}