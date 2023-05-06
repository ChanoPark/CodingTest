package Programmers;

import java.util.*;

public class GameMapShortestDistance {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        //BFS
        boolean[][] ch = new boolean[n][m];
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(0, 0));

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Pos pos = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n
                        && maps[ny][nx] == 1 && ch[ny][nx] == false) {
                    ch[ny][nx] = true;
                    maps[ny][nx] = maps[pos.y][pos.x] + 1;
                    queue.offer(new Pos(nx, ny));
                }
            }
        }

        return ch[n - 1][m - 1] ? maps[n - 1][m - 1] : -1;
    }

    public static class Pos {
        private int x;
        private int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
