import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Prob5_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] moves = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) moves[i] = Integer.parseInt(st.nextToken()) - 1;

        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for (int pos : moves) {
            for (int i = 0; i < N; i++) {
                if (board[i][pos] != 0) {
                    if (!stack.isEmpty() && stack.peek() == board[i][pos]) {
                        stack.pop();
                        answer++;
                    } else {
                        stack.push(board[i][pos]);
                    }
                    board[i][pos] = 0;
                    break;
                }
            }
        }
        System.out.println(answer * 2);
    }
}
