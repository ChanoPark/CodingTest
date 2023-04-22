package Programmers;

import java.util.*;

public class SearchPrime {
    private static int[] ch;
    private static char[] nums;
    private static int maxLength;
    private static Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        nums = numbers.toCharArray();
        ch = new int[nums.length];

        for (int i = 1; i <= nums.length; i++) {
            maxLength = i;
            dfs("", 0);
        }

        return set.size();
    }

    private void dfs(String number, int idx) {
        if (idx == maxLength) {
            if (number.length() > 0 && isPrime(Integer.parseInt(number))) {
                set.add(Integer.parseInt(number));
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (ch[i] == 1) continue;
                ch[i] = 1;
                dfs(number + nums[i], idx + 1);
                ch[i] = 0;
            }
        }
    }

    private boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
