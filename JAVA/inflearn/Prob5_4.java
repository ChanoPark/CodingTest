import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Prob5_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        Stack<Integer> stack = new Stack<>();

        for (char c : input) {
            if (Character.isDigit(c)) stack.push(c - 48);
            else {
                int n1 = stack.pop();
                int n2 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(n1 + n2);
                        break;
                    case '-':
                        stack.push(n2 - n1);
                        break;
                    case '*':
                        stack.push(n1 * n2);
                        break;
                    case '/':
                        stack.push(n2 / n1);
                        break;
                }
            }
        }
        System.out.println(stack.peek());
    }
}
