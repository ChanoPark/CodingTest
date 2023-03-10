import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob1_8 {
    /**
     * replaceAll 활용
     */
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase().replaceAll("[^A-Z]", "");
        String reverse = new StringBuilder(str).reverse().toString();

        if (str.equals(reverse)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();
        char[] strArr = str.toCharArray();
        int lt = 0;
        int rt = str.length() - 1;

        while (lt < rt) {
            if (!Character.isAlphabetic(strArr[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(strArr[rt])) {
                rt--;
            } else {
                if (strArr[lt] != strArr[rt]) {
                    System.out.println("NO");
                    return;
                }
                lt++;
                rt--;
            }
        }
        System.out.println("YES");
    }
}
