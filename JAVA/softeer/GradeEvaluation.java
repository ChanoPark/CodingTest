package softeer;

import java.util.*;
import java.io.*;

public class GradeEvaluation {
    public static int n;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[3][n];
        int[] totalArr = new int[n];
        PriorityQueue<Participant> queue = new PriorityQueue<>();

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int score = Integer.parseInt(st.nextToken());
                arr[i][j] = score;
                queue.offer(new Participant(j, score));
                totalArr[j] += score;
            }
            getGrade(queue);

        }

        for (int i = 0; i < n; i++) {
            queue.offer(new Participant(i, totalArr[i]));
        }

        getGrade(queue);
    }

    public static void getGrade(PriorityQueue<Participant> queue) {
        int[] gradeArr = new int[n];

        Participant first = queue.poll();
        gradeArr[first.idx] = 1;
        int prev = first.score;
        int grade = 1;
        int sameCount = 1;

        while (!queue.isEmpty()) {
            Participant p = queue.poll();

            if (prev == p.score) {
                sameCount++;
            } else {
                grade += sameCount;
                sameCount = 1;
            }

            gradeArr[p.idx] = grade;
            prev = p.score;
        }

        for (int p : gradeArr) {
            System.out.print(p + " ");
        }
        System.out.println();
    }

    public static class Participant implements Comparable<Participant> {
        private int idx;
        private int score;

        public Participant(int idx, int score) {
            this.idx = idx;
            this.score = score;
        }

        @Override
        public int compareTo(Participant o) {
            return o.score - this.score;
        }
    }
}
