package Programmers;

public class Rank {
    public int solution(int n, int[][] results) {
        int answer = 0;

        int[][] ranks = new int[n + 1][n + 1];
        for (int[] r : results) {
            ranks[r[0]][r[1]] = 1;
        }

        //플로이드 와샬
        for (int i = 1; i <= n; i++) { //경유
            for (int j = 1; j <= n; j++) { //시작
                for (int k = 1; k <= n; k++) { // 도착
                    if (ranks[j][i] == 1 && ranks[i][k] == 1) ranks[j][k] = 1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int temp = 0;
            for (int j = 1; j <= n; j++) {
                if (ranks[i][j] == 1 || ranks[j][i] == 1) temp++;
            }

            if (temp == n - 1) answer++;
        }

        return answer;
    }
}
