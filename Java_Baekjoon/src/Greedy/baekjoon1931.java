package Greedy;

// Runtime Error.
// 배열 메모리 초과?..... -> 다시 해보기.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Room implements Comparable<Room> {
    int start;
    int end;

    public Room() {
    }

    public Room(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Room room) {
        if (this.end == room.end) {
            return this.start - room.start;
        }
        return this.end - room.end;
    }
}

public class baekjoon1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Room> roomList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            roomList.add(new Room(start, end));
        }

        Collections.sort(roomList);

        int ans = 0;
        int now = 0;

        for (Room room : roomList) {
            if (now <= room.start) {
                now = room.end;
                ans++;
            }
        }
        System.out.println(ans);
    }

}
