import java.util.*;

class MyCalendarTwo {

    private List<int[]> bookings = new ArrayList<>();
    private List<int[]> overlaps = new ArrayList<>();

    public MyCalendarTwo() {
    }

    public boolean book(int startTime, int endTime) {

        // Check if new booking creates a triple booking
        for (int[] interval : overlaps) {
            if (startTime < interval[1] && endTime > interval[0]) {
                return false;
            }
        }

        // Find overlaps with existing bookings
        for (int[] interval : bookings) {
            int start = Math.max(startTime, interval[0]);
            int end = Math.min(endTime, interval[1]);

            if (start < end) {
                overlaps.add(new int[]{start, end});
            }
        }

        bookings.add(new int[]{startTime, endTime});

        return true;
    }
}