package Programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Pokemon {
    public int solution(int[] nums) {
        int answer = 0;

        int size = nums.length / 2;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        answer = Math.min(set.size(), size);

        //HashMap
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//
//        int types = map.keySet().size();
//        answer = Math.min(types, size);
        return answer;
    }
}
