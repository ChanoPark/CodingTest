import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob1_7 {
    /**
     * while문 활용
     */
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();

        char[] strArr = str.toCharArray();
        int lt=0;
        int rt=str.length()-1;

        while (lt < rt) {
            if (strArr[lt] != strArr[rt]) {
                System.out.println("NO");
                return;
            }
            lt++;
            rt--;
        }
        System.out.println("YES");
    }

    /**
     * for문 활용
     */
    public void solution2() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();

        for (int i=0; i<str.length()/2 ; i++) {
            if (str.charAt(i) != str.charAt(str.length()-1-i)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static void main(String[] args) throws Exception {
//        Main t = new Main();
//        t.solution();
//        t.solution2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder(br.readLine());

        if (str.toString().equalsIgnoreCase(str.reverse().toString())) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
