import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Prob5_1 {
    /**
     * Stack 자료구조 사용.
     */
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] p = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char x : p) {
            if (x == '(') stack.push('(');
            else {
                if (stack.contains('(')) stack.pop();
                else {
                    System.out.println("NO");
                    return;
                }
            }
        }

        if (stack.isEmpty()) System.out.println("YES");
        else System.out.println("NO");

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] p = br.readLine().toCharArray();
        ArrayList<Character> stack = new ArrayList<>();

        for (char x : p) {
            if (x == '(') stack.add('(');
            else {
                if (stack.contains('(')) stack.remove(Character.valueOf('('));
                else {
                    System.out.println("NO");
                    return;
                }
            }
        }

        if (stack.isEmpty()) System.out.println("YES");
        else System.out.println("NO");
    }
}
