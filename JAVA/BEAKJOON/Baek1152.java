import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek1152 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        if (input.length() == 0) System.out.println(0);
        else System.out.println(input.split(" ").length);
    }
}
