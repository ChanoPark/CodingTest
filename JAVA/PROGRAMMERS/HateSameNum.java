package Programmers;

import java.util.ArrayList;
import java.util.List;

public class HateSameNum {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        int last = -1;

        for (int x : arr) {
            if (last != x) {
                list.add(x);
                last = x;
            }
        }
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
