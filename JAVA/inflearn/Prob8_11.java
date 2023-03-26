import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Prob8_11 {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[7][7];
        int result = -1;
        int level = 0;

        for (int i = 0; i < 7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));

        while (!queue.isEmpty()) {
            List<Point> pointList = new ArrayList<>();

            while (!queue.isEmpty()) pointList.add(queue.poll());

            for (Point point : pointList) {
                int x = point.getX();
                int y = point.getY();
                board[y][x] = 1;
                if (x == 6 && y == 6) result = level;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && board[ny][nx] == 0) {
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
            level++;
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
