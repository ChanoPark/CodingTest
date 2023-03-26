import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Prob8_12 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        int result = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] board = new int[n][m];

        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int t = Integer.parseInt(st.nextToken());
                if (t == 1) queue.offer(new Point(j, i));
                board[i][j] = t;
            }
        }

        while (!queue.isEmpty()) {
            boolean flag = false;
            List<Point> pointList = new ArrayList<>();
            while (!queue.isEmpty()) pointList.add(queue.poll());

            for (Point point : pointList) {
                for (int i = 0; i < 4; i++) {
                    int nx = point.getX() + dx[i];
                    int ny = point.getY() + dy[i];

                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[ny][nx] == 0) {
                        board[ny][nx] = 1;
                        queue.offer(new Point(nx, ny));
                        flag = true;
                    }
                }
            }

            if (flag) result++;
        }

        Loop:
        for (int[] x : board) {
            for (int i : x) {
                if (i == 0) {
                    result = -1;
                    break Loop;
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
