import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Prob1_10 {
    /**
     * 왼쪽에서 쭉 돌고 오른쪽에서 돌면서 비교하는 방법
     */
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] split = input.split(" ");

        String s = split[0];
        char t = split[1].toCharArray()[0];
        int[] answer = new int[s.length()];

        int idx = 1000;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                idx = 0;
                answer[i] = idx;
            } else {
                answer[i] = ++idx;
            }
        }

        idx = 1000;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == t) idx = 0;
            else {
                answer[i] = Math.min(answer[i], ++idx);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            System.out.print(answer[i] + " ");
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] split = input.split(" ");

        String s = split[0];
        char t = split[1].toCharArray()[0];

        int[] answer = new int[s.length()];
        ArrayList<Integer> index = new ArrayList<>();

        int idx = 0;
        for (char c : s.toCharArray()) {
            if (c == t) {
                index.add(idx);
            }
            idx++;
        }

        for (int i = 0; i < s.length(); i++) {
            int distance = 1000;
            for (int p : index) {
                if (distance > Math.abs(p - i)) {
                    distance = Math.abs(p - i);
                }
            }
            answer[i] = distance;
        }

        for (int i = 0; i < s.length(); i++) {
            System.out.print(answer[i] + " ");
        }

    }
}
