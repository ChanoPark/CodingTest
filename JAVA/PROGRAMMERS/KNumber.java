package Programmers;

import java.util.Arrays;

public class KNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int idx = 0;
        for (int[] command : commands) {
            int i = command[0] - 1;
            int j = command[1] - 1;
            int k = command[2] - 1;

            int size = j == i ? 1 : j - i + 1;
            int[] arr = new int[size];
            int x = 0;
            for (int l = i; l <= j && x < size; l++, x++) arr[x] = array[l];

            Arrays.sort(arr);
            answer[idx++] = arr[k];
        }

        return answer;
    }
}
