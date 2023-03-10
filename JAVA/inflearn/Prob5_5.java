import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Prob5_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length; i++) {
            if (input[i] == '(') stack.push(input[i]);
            else if (input[i] == ')' && input[i - 1] == ')') { //닫는괄호
                stack.pop();
                answer++;
            } else { //레이저 닫기
                stack.pop();
                answer += stack.size();
            }
        }
        System.out.println(answer);
    }
}
