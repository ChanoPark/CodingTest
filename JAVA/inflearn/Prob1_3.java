import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob1_3 {
    /**
     * 문자열을 자르면서 찾는 방법.
     */
    public String solution(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE;
        int pos;

        while((pos = str.indexOf(" ")) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len > m) {
                m=len;
                answer=tmp;
            }
            str = str.substring(pos+1);
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] strArr = str.split(" ");
        String result = strArr[0];

        for (String word : strArr) {
            if (result.length() < word.length()) result = word;
        }

        System.out.println(result);
    }
}
