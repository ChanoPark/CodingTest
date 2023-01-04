import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob1_9 {
    /**
     * 직접 숫자만 걸러내기
     */
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        char[] str = br.readLine().toCharArray();

        for (char x : str) {
            //ASCII: 48~57까지가 문자 '0'~'9'임.
            if (48 <= x && x <=57) {
                answer = answer * 10 + (x-48);
            }
        }
        System.out.println(answer);
    }

    /**
     * Character.isDigit()
     */
    public void solution2() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        char[] str = br.readLine().toCharArray();

        for (char x : str) {
            if (Character.isDigit(x)) {
                answer.append(x);
            }
        }
        System.out.println(Integer.parseInt(answer.toString())); //문자열로 숫자를 받을 때, 첫 번째 자리 숫자가 0인경우 주의**
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().replaceAll("[^0-9]", "");
        System.out.println(Integer.parseInt(str));
    }
}
