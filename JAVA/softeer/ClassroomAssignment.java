package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ClassroomAssignment {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(start, end));
        }

        Collections.sort(lectures);

        Lecture firstLecture = lectures.get(0);
        int last = firstLecture.getEnd();
        lectures.remove(firstLecture);

        int answer = 1;

        for (Lecture lecture : lectures) {
            if (lecture.getStart() >= last) {
                last = lecture.getEnd();
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static class Lecture implements Comparable<Lecture> {
        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        private int start;
        private int end;

        public int getEnd() {
            return this.end;
        }

        public int getStart() {
            return this.start;
        }

        @Override
        public int compareTo(Lecture o) {
            return this.end - o.getEnd();
        }

    }
}
