package Programmers;

public class WordTranslation {
    private static String[] words;
    private static boolean[] ch;
    private static int answer;
    private static String target;

    public int solution(String begin, String t, String[] w) {
        answer = 51;
        target = t;
        words = w;

        ch = new boolean[words.length];
        boolean flag = false;
        for (String word : words) {
            if (word.equals(target)) {
                flag = true;
                break;
            }
        }

        if (!flag) return 0;
        dfs(begin, 0);
        return answer == 51 ? 0 : answer;
    }

    public void dfs(String word, int cnt) {
        if (word.equals(target)) {
            answer = Math.min(cnt, answer);
        }
        for (int i=0; i<words.length; i++) {
            if (check(words[i], word) && !ch[i]) {
                ch[i] = true;
                dfs(words[i], cnt + 1);
                ch[i] = false;
            }
        }
    }

    private boolean check(String target, String word) {
        int cnt = 0;
        for (int i=0; i<word.length(); i++) {
            if (target.charAt(i) == word.charAt(i)) cnt++;
        }

        return cnt == word.length() - 1;
    }
}
