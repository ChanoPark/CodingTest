import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prob9_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Room[] rooms = new Room[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            rooms[i] = new Room(start, end);
        }

        Arrays.sort(rooms);
        int answer = 0;
        int prevEnd = 0;

        for (Room r : rooms) {
            if (r.getStart() >= prevEnd) {
                answer++;
                prevEnd = r.getEnd();
            }
        }

        System.out.println(answer);
    }

    public static class Room implements Comparable<Room> {
        private int start;
        private int end;

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Room o) {
            int endSort = this.end - o.getEnd();
            if (endSort == 0) return this.start - o.getStart();
            else return endSort;
        }
    }
}
