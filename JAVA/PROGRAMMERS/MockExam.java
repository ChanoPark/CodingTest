package Programmers;

import java.util.*;

public class MockExam {
    public int[] solution(int[] answers) {
        int[] result = new int[3];

        Queue<Integer> A = new LinkedList<>();
        A.offer(1);
        A.offer(2);
        A.offer(3);
        A.offer(4);
        A.offer(5);

        Queue<Integer> B = new LinkedList<>();
        B.offer(2);
        B.offer(1);
        B.offer(2);
        B.offer(3);
        B.offer(2);
        B.offer(4);
        B.offer(2);
        B.offer(5);
        //3311 2244 55
        Queue<Integer> C = new LinkedList<>();
        C.offer(3);
        C.offer(3);
        C.offer(1);
        C.offer(1);
        C.offer(2);
        C.offer(2);
        C.offer(4);
        C.offer(4);
        C.offer(5);
        C.offer(5);

        for (int answer : answers) {
            int a = A.poll();
            int b = B.poll();
            int c = C.poll();
            A.offer(a);
            B.offer(b);
            C.offer(c);

            if (answer == a) result[0]++;
            if (answer == b) result[1]++;
            if (answer == c) result[2]++;
        }


        List<Integer> list = new ArrayList<>();
        int max = Math.max(Math.max(result[0], result[1]), result[2]);

        for (int i = 0; i < 3; i++) {
            if (result[i] == max) list.add(i + 1);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
