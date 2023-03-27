import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Prob8_14 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    queue.offer(new Point(j, i));

                    while (!queue.isEmpty()) {
                        Point point = queue.poll();

                        for (int k = 0; k < 8; k++) {
                            int nx = point.getX() + dx[k];
                            int ny = point.getY() + dy[k];

                            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[ny][nx] == 1) {
                                queue.offer(new Point(nx, ny));
                                board[ny][nx] = 0;
                            }
                        }
                    }
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    public static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
