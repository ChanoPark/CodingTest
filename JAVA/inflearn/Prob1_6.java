import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Prob1_6 {
    /**
     * indexOf를 활용한 해결
     */
    public StringBuilder solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder result = new StringBuilder();

        for (int i = 0 ; i < str.length() ; i++) {
            if (str.indexOf(str.charAt(i)) == i) result.append(str.charAt(i));
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
//        Main T = new Main();
//        System.out.println(T.solution());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder result = new StringBuilder();

        Set<String> includeWord = new HashSet<>();

        char[] strArr = str.toCharArray();

        for (char s : strArr) {
            if (!includeWord.contains(String.valueOf(s))) {
                result.append(s);
                includeWord.add(String.valueOf(s));
            }
        }
        System.out.println(result);
    }
}
