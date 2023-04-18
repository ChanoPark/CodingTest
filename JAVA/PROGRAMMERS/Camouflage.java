package Programmers;

import java.util.*;

public class Camouflage {
    private static int answer;
    private static Map<String, Integer> map;
    private static int[] ch;
    private static List<String> keys;
    private static int target;

    public int solution(String[][] clothes) {
        answer = 0;
        map = new HashMap<>();

        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        keys = new ArrayList<>(map.keySet());
        ch = new int[map.size()];

        //조합을 활용하는 경우 시간 초과 발생.
//         for (Map.Entry<String, Integer> entry : map.entrySet()) {
//             answer+= entry.getValue();
//         }

//         for (int i=map.size(); i>1; i--) {
//             target = i;
//             dfs(0,0);
//         }

        //전체 경우의 수(안입은 것 포함) - 1;
        int temp = 1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            temp *= entry.getValue() + 1;
        }
        answer = temp - 1;

        return answer;
    }

    public void dfs(int idx, int len) {
        if (len == target) {
            int temp = 1;
            for (int i = 0; i < len; i++) {
                temp *= map.get(keys.get(ch[i]));
            }
            answer += temp;
        } else {
            for (int i = idx; i < map.size(); i++) {
                ch[len] = i;
                dfs(i + 1, len + 1);
            }
        }
    }
}
