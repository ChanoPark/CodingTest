import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Prob9_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Time> arr = new ArrayList<>();

        for (int i=0; i<n; i++) {
            String[] inputs = br.readLine().split(" ");
            arr.add(new Time(Integer.parseInt(inputs[0]), 's'));
            arr.add(new Time(Integer.parseInt(inputs[1]), 'e'));
        }

        Collections.sort(arr);
        int con = 0;
        int answer = 0;
        for (Time t : arr) {
            if (t.getAct() == 'e') con--;
            else con++;
            answer = Math.max(con, answer);
        }

        System.out.println(answer);
    }

    public static class Time implements Comparable<Time> {
        private int time;
        private char act;

        public Time(int time, char act) {
            this.time = time;
            this.act = act;
        }

        public int getTime() {
            return time;
        }

        public char getAct() {
            return act;
        }

        @Override
        public int compareTo(Time o) {
            if (this.time == o.getTime()) return this.act - o.getAct();
            else return this.time - o.getTime();
        }
    }
}