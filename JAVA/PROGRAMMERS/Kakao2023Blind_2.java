package Programmers;

import java.util.*;

public class Kakao2023Blind_2 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<Integer> d_stack = new Stack<>();
        Stack<Integer> p_stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < deliveries[i]; j++) d_stack.push(i + 1);
            for (int j = 0; j < pickups[i]; j++) p_stack.push(i + 1);
        }

        while (!(d_stack.isEmpty() && p_stack.isEmpty())) {

            int d_peek = 0;
            int p_peek = 0;

            if (!d_stack.isEmpty()) d_peek = d_stack.peek();
            if (!p_stack.isEmpty()) p_peek = p_stack.peek();

            for (int i = 0; i < cap; i++) {
                if (!d_stack.isEmpty()) d_stack.pop();
                if (!p_stack.isEmpty()) p_stack.pop();
            }

            answer += Math.max(d_peek, p_peek) * 2L;
        }


        return answer;
    }
}
