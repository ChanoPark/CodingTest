import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek11723 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int bit = 0;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String operation = input[0];
            int num = 0;
            if (input.length > 1) {
                num = Integer.parseInt(input[1]) - 1;
            }

            switch (operation) {
                case "add":
                    bit |= (1 << num);
                    break;
                case "remove":
                    bit = bit & ~(1 << num);
                    break;
                case "check":
                    sb.append((bit & (1 << num)) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    bit ^= (1 << num);
                    break;
                case "all":
                    bit |= (~0);
                    break;
                case "empty":
                    bit &= 0;
                    break;
            }
        }
        System.out.print(sb.toString());
    }
}
