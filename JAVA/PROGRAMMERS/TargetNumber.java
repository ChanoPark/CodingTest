package Programmers;

public class TargetNumber {
    private static int T;
    private static int[] N;
    private static int answer = 0;

    public int solution(int[] numbers, int target) {
        T = target;
        N = numbers;
        dfs(0, 0);
        return answer;
    }

    public void dfs(int idx, int sum) {
        if (idx == N.length) {
            if (sum == T) answer++;
        } else {
            dfs(idx + 1, sum + N[idx]);
            dfs(idx + 1, sum - N[idx]);
        }
    }
}
// 0-3 0-1
// 2-3
/**
 * 1 1 0 1
 * 1 1 0 0
 * 0 0 1 1
 * 1 0 1 1
 */