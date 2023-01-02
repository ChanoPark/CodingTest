import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob1_5 {

    /**
     * Character.isAlphabetic() 메소드를 통해 특수문자를 걸러내는 방법.
     */
    public void solution(String word) {
        char[] wordArr = word.toCharArray();
        char tmp;
        int lt = 0;
        int rt = word.length()-1;
        while (lt < rt) {
            if (!Character.isAlphabetic(wordArr[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(wordArr[rt])) {
                rt--;
            } else {
                tmp = wordArr[lt];
                wordArr[lt] = wordArr[rt];
                wordArr[rt] = tmp;
                lt++;
                rt--;
            }
        }
        System.out.println(String.valueOf(wordArr));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char tmp;
        String word = br.readLine();
        char[] wordArr = word.toCharArray();
        int lt = 0;
        int rt = word.length()-1;
        while (lt < rt) {
            if (!((wordArr[lt] >= 'a' && wordArr[lt] <= 'z') || (wordArr[lt] >= 'A' && wordArr[lt] <= 'Z'))) {
                lt++;
            } else if (!((wordArr[rt] >= 'a' && wordArr[rt] <= 'z') || (wordArr[rt] >= 'A' && wordArr[rt] <= 'Z'))) {
                rt--;
            } else {
                tmp = wordArr[lt];
                wordArr[lt] = wordArr[rt];
                wordArr[rt] = tmp;
                lt++;
                rt--;
            }
        }
        System.out.println(String.valueOf(wordArr));
    }
}
