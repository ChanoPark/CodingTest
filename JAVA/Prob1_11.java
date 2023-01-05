import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob1_11 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int idx = 0;

        while (idx < input.length) {
            int length = 0;

            System.out.print(input[idx]);

            while (idx + length < input.length && input[idx] == input[idx + length]) {
                length++;
            }

            if (length == 1) {
                idx++;
            } else {
                System.out.print(length);
                idx += length;
            }
        }
    }
}
