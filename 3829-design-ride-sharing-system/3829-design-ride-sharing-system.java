import java.util.*;

class RideSharingSystem {
    private Queue<Integer> riders;
    private Queue<Integer> drivers;
    private Set<Integer> activeRiders;

    public RideSharingSystem() {
        riders = new LinkedList<>();
        drivers = new LinkedList<>();
        activeRiders = new HashSet<>();
    }

    public void addRider(int riderId) {
        riders.offer(riderId);
        activeRiders.add(riderId);
    }

    public void addDriver(int driverId) {
        drivers.offer(driverId);
    }

    public int[] matchDriverWithRider() {
        while (!riders.isEmpty()
                && !activeRiders.contains(riders.peek())) {
            riders.poll();
        }

        if (riders.isEmpty() || drivers.isEmpty()) {
            return new int[]{-1, -1};
        }

        int driverId = drivers.poll();
        int riderId = riders.poll();
        activeRiders.remove(riderId);

        return new int[]{driverId, riderId};
    }

    public void cancelRider(int riderId) {
        activeRiders.remove(riderId);
    }
}