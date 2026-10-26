class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1, prev = -1;
        int minDist = Integer.MAX_VALUE;
        int index = 1;

        ListNode curr = head.next;
        ListNode before = head;

        while (curr.next != null) {
            if ((curr.val > before.val && curr.val > curr.next.val) ||
                (curr.val < before.val && curr.val < curr.next.val)) {

                if (prev != -1) {
                    minDist = Math.min(minDist, index - prev);
                } else {
                    first = index;
                }

                prev = index;
            }

            before = curr;
            curr = curr.next;
            index++;
        }

        if (first == -1 || first == prev) {
            return new int[]{-1, -1};
        }

        return new int[]{minDist, prev - first};
    }
}