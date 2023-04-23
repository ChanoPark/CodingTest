package Programmers;

public class PaintOver {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int painted = 0;

        for (int s : section) {
            if (painted <= s) {
                painted = s + m;
                answer++;
            }
        }

        return answer;
    }
}
