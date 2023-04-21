package Programmers;

import java.util.*;

public class Network {
    private static int[] unf;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        int len = computers.length;
        unf = new int[len];
        for (int i = 0; i < len; i++) unf[i] = i;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len && j != i; j++) {
                if (computers[i][j] == 1) {
                    union(i, j);
                    computers[j][i] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == unf[i]) answer++;
        }

        System.out.println(Arrays.toString(unf));

        return answer;
    }

    public void union(int v1, int v2) {
        int findV1 = find(v1);
        int findV2 = find(v2);

        if (findV1 > findV2) unf[findV1] = findV2;
        else unf[findV2] = findV1;
    }

    private int find(int v1) {
        if (unf[v1] == v1) return v1;
        else return unf[v1] = find(unf[v1]);
    }
}
