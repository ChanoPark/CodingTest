package Programmers;

import java.util.*;

public class DoublePriorityQueue {
    public int[] solution(String[] operations) {
        int[] answer = {};

        List<Integer> dq = new ArrayList<>();

        for (String op : operations) {
            String[] ops = op.split(" ");
            String oper = ops[0];
            String value = ops[1];

            if (oper.equals("I")) {
                dq.add(Integer.parseInt(value));
            } else if (!dq.isEmpty()) {
                if (value.equals("1")) {
                    int tmp = Integer.MIN_VALUE;
                    for (Integer x : dq) {
                        tmp = Math.max(tmp, x);
                    }

                    dq.remove(Integer.valueOf(tmp));
                } else {
                    int tmp = Integer.MAX_VALUE;
                    for (Integer x : dq) {
                        tmp = Math.min(tmp, x);
                    }

                    dq.remove(Integer.valueOf(tmp));
                }
            }
        }

        if (dq.isEmpty()) {
            return new int[]{0, 0};
        } else {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (Integer x : dq) {
                max = Math.max(max, x);
                min = Math.min(min, x);
            }

            return new int[]{max, min};
        }
    }
}
