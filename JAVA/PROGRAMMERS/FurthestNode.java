package Programmers;

import java.util.*;

public class FurthestNode {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        //BFS
        int[] ch = new int[n + 1];
        List<List<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i <= n; i++) nodes.add(new ArrayList<>());

        for (int[] e : edge) {
            nodes.get(e[0]).add(e[1]);
            nodes.get(e[1]).add(e[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        ch[1] = 1;

        while (!queue.isEmpty()) {
            int idx = queue.poll();

            for (int node : nodes.get(idx)) {
                if (ch[node] == 0) {
                    ch[node] = ch[idx] + 1;
                    queue.add(node);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int c : ch) {
            if (c > max) {
                max = c;
                answer = 1;
            } else if (c == max) {
                answer++;
            }
        }

        return answer;
    }
}
