import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob1_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringBuilder result = new StringBuilder();

//        for (char s : str.toCharArray()) {
//            if (Character.isLowerCase(s)) result.append(Character.toUpperCase(s));
//            else result.append(Character.toLowerCase(s));
//        }

        //아스키코드 활용
        for (char s : str.toCharArray()) {
            if (s < 97) result.append((char)(s+32));
            else result.append((char)(s-32));
        }

        System.out.println(result);
    }
}
