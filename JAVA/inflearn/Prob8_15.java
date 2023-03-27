import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Prob8_15 {
    private static List<Point> house;
    private static List<Point> pizza;
    private static int[] ch;
    private static int result = Integer.MAX_VALUE;
    private static int m;
    private static int totalPizza;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        int[][] board = new int[n][n];
        house = new ArrayList<>();
        pizza = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) house.add(new Point(i, j));
                else if (x == 2) pizza.add(new Point(i, j));
                board[i][j] = x;
            }
        }

        totalPizza = pizza.size();
        ch = new int[m];
        dfs(0, 0);
        System.out.println(result);
    }

    private static void dfs(int idx, int len) {
        if (len == m) {
            //거리 계산
            int totalDistance = 0;
            for (Point h : house) {
                int distance = Integer.MAX_VALUE;
                for (int x : ch) {
                    Point p = pizza.get(x);
                    distance = Math.min(Math.abs(h.getX() - p.getX()) + Math.abs(h.getY() - p.getY()), distance);
                }
                totalDistance += distance;
            }
            result = Math.min(result, totalDistance);
        } else {
            for (int i = idx; i < totalPizza; i++) {
                ch[len] = i;
                dfs(i + 1, len + 1);
            }
        }
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