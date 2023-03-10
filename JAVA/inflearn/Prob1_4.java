import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob1_4 {
    /**
     * StringBuilder의 reverse 메소드 활용
     */
    public void solution(String str) {
        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb.reverse().toString());
    }

    /**
     * 문자열 직접 뒤집기
     */
    public void solution2(String str) {
        char[] strArr = str.toCharArray();
        char[] reverse = new char[str.length()];
        int lt = 0;
        int rt = str.length() - 1;
        char tmp;

        while (lt < rt) {
            tmp = reverse[rt];
            reverse[rt] = strArr[lt];
            reverse[lt] = tmp;
            lt++;
            rt--;
        }
        String result = String.valueOf(reverse);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String word = br.readLine();
            StringBuilder result = new StringBuilder();

            for (int j = word.length() - 1; j >= 0; j--) {
                result.append(word.charAt(j));
            }

            System.out.println(result);
        }
    }
}
