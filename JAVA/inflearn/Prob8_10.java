import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob8_10 {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] board;
    private static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[7][7];

        for (int i = 0; i < 7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(result);
    }

    private static void dfs(int xPos, int yPos) {
        if (xPos == 6 && yPos == 6) {
            result++;
        } else {
            board[yPos][xPos] = 1;
            for (int i = 0; i < 4; i++) {
                int x = xPos + dx[i];
                int y = yPos + dy[i];

                if (x >= 0 && x < 7 && y >= 0 && y < 7 && board[y][x] == 0) {
                    dfs(x, y);
                }
            }
        }
        board[yPos][xPos] = 0;
    }
}
