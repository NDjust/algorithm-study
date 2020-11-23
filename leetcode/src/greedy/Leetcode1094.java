package greedy;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1094 {

    public boolean carPooling(int[][] trips, int capacity) {
        List<Trip> tripList = new ArrayList<>();

        for (int[] trip : trips) {
            tripList.add(new Trip(trip[0], trip[1], trip[2]));
        }

        int maxTime = getMaxTime(tripList);


        for (int i = 0; i < maxTime; i++) {
            int currCapacity = getCurrentCapacity(i, tripList);

            if (currCapacity > capacity) {
                return false;
            }
        }

        return true;
    }

    private int getCurrentCapacity(final int currTime, final List<Trip> tripList) {
        int capacity = 0;

        for (Trip trip : tripList) {
            if (trip.startLocation <= currTime && trip.endLocation > currTime) {
                capacity += trip.passengers;
            }
        }

        return capacity;
    }

    private int getMaxTime(final List<Trip> tripList) {
        int maxTime = Integer.MIN_VALUE;

        for (Trip trip : tripList) {
            maxTime = Math.max(maxTime, trip.endLocation);
        }

        return maxTime;
    }

    private static class Trip {
        int passengers;
        int startLocation;
        int endLocation;


        public Trip(final int passengers, final int startLocation, final int endLocation) {
            this.passengers = passengers;
            this.startLocation = startLocation;
            this.endLocation = endLocation;
        }
    }

    public static void main(String[] args) {
        Leetcode1094 leetcode1094 = new Leetcode1094();
        int[][] trips = new int[][] {
                {2,1,5}, {3,3,7}
        };
        boolean b = leetcode1094.carPooling(trips, 4);

        System.out.println(b);
    }
}
