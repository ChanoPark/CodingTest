import java.util.Scanner;

public class Prob1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next().toUpperCase();
        char c = Character.toUpperCase(sc.next().charAt(0));
        int result = 0;

        for (char x : str.toCharArray()) {
            if (x == c) result++;
        }

        System.out.println(result);
    }
}
