package Programmers;

import java.util.*;

public class HIndex {
    public int solution(int[] citations) {
        int answer = 0;
        int idx = 0;
        Arrays.sort(citations);

        for (int i = 0; i <= citations.length; i++) { //기준값

            while (idx < citations.length && citations[idx] < i) idx++;

            if (citations.length - idx >= i)
                answer = i;
        }

        return answer;
    }
}
