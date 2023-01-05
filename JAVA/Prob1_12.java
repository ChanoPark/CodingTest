import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob1_12 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int idx = 0;
        for (int i = 0; i < n; i++) {
            String word = input.substring(idx, idx + 7);
            idx += 7;

            word = word.replace('#', '1');
            word = word.replace('*', '0');

            int binary = Integer.parseInt(word, 2);
            System.out.print(Character.toChars(binary));
        }
    }
}
