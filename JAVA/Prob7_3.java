import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob7_3 {
    public static int recursive(int n) {
        if (n == 1) return n;
        else return recursive(n - 1) * n;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(recursive(n));
    }
}
