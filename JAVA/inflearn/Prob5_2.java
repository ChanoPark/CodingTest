import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Prob5_2 {
    /**
     * 문자까지 다 넣고 여는괄호 나올떄까지 pop하는 방법
     */
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char c : input) {
            if (c == ')') {
                while (!stack.pop().equals('(')) ;
            } else {
                stack.push(c);
            }
        }

        for (Character character : stack) System.out.print(character);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();

        for (char c : input) {
            if (c == '(') stack.push('(');
            else if (c == ')') stack.pop();
            else {
                if (stack.isEmpty()) answer.append(c);
            }
        }
        System.out.println(answer);
    }
}
