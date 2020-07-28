package in.samratc.main.arrays;

import java.util.*;

public class MeetingRooms {
    /**
     * Meeting rooms
     * Given an array of array of integers A of size N x 2 denoting time intervals of different meetings.
     * <p>
     * Where:
     * <p>
     * A[i][0] = start time of the ith meeting.
     * <p>
     * A[i][1] = end time of the ith meeting.
     * <p>
     * find the minimum number of conference rooms required so that all meetings can be done.
     */

    public int solve(int[][] meetings) {
        if (meetings == null || meetings.length == 0)
            return 0;
        int n = meetings.length;
        TreeSet<Integer> events = new TreeSet<>();
        Map<Integer,Integer> startEvents = new HashMap<>(), endEvents = new HashMap<>();
        for (int[] meeting : meetings) {
            events.add(meeting[0]);
            startEvents.put(meeting[0], startEvents.getOrDefault(meeting[0], 0) + 1);
            events.add(meeting[1]);
            endEvents.put(meeting[1], endEvents.getOrDefault(meeting[1], 0) + 1);
        }
        int currRoom = 0, maxRoom = 0;
        for (int event : events) {
            if (endEvents.containsKey(event))
                currRoom -= endEvents.get(event);
            if (startEvents.containsKey(event))
                currRoom += startEvents.get(event);
            maxRoom = Math.max(maxRoom, currRoom);
        }
        return maxRoom;
    }

    //Driver
    public static void main(String... args) {
        MeetingRooms mr = new MeetingRooms();
        int[][] arr = {
                {4, 10}, {22, 26}, {22, 28}, {24, 26}, {13, 19},{6, 27},
                {10, 26},{23, 29},{8, 22},{10, 11},{12, 21}};
        System.out.println(mr.solve(arr));
    }
}
