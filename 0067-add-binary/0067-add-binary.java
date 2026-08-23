class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        // Loop until both strings are processed and no carry remains
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0'; // Convert char to int
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0'; // Convert char to int
                j--;
            }

            sb.append(sum % 2); // Current bit value (0 or 1)
            carry = sum / 2;    // New carry overflow (0 or 1)
        }

        return sb.reverse().toString();
    }
}
