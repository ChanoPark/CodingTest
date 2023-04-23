package Programmers;

import java.util.*;

public class NearestLetter {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (map.containsKey(t)) {
                answer[i] = i - map.get(t);
                map.put(t, i);
            } else {
                answer[i] = -1;
                map.put(t, i);
            }
        }

        return answer;
    }
}
