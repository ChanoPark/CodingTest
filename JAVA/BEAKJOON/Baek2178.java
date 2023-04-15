package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek2178 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        int[][] arr = new int[n][m];
        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) arr[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int px = p.getX();
            int py = p.getY();
            visited[py][px] = 1;

            for (int i = 0; i < 4; i++) {
                int mx = px + dx[i];
                int my = py + dy[i];

                if (mx >= 0 && mx < m && my >= 0 && my < n && arr[my][mx] == 1 && visited[my][mx] == 0) {
                    queue.offer(new Point(mx, my));
                    arr[my][mx] = arr[py][px] + 1;
                }
            }
        }

        System.out.println(arr[n - 1][m - 1]);
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
