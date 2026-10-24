class Solution {
    public boolean checkRecord(String s) {
        int absences = 0;
        int late = 0;

        for (char c : s.toCharArray()) {
            if (c == 'A') {
                absences++;
            }

            if (c == 'L') {
                late++;
            } else {
                late = 0;
            }

            if (absences >= 2 || late >= 3) {
                return false;
            }
        }

        return true;
    }
}