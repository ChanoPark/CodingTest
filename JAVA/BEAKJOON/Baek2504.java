import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek2504 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int temp = 1;

        for (int i = 0; i < input.length; i++) {
            if (input[i] == '(') {
                stack.push('(');
                temp *= 2;
            } else if (input[i] == '[') {
                stack.push('[');
                temp *= 3;
            } else if (input[i] == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    answer = 0;
                    break;
                }

                if (input[i - 1] == '(') answer += temp;
                stack.pop();
                temp /= 2;
            } else {
                if (stack.isEmpty() || stack.peek() != '[') {
                    answer = 0;
                    break;
                }

                if (input[i - 1] == '[') answer += temp;
                stack.pop();
                temp /= 3;
            }
        }
        System.out.println(!stack.isEmpty() ? 0 : answer);
    }
}
