import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Prob6_7 {
    public static class Point implements Comparable<Point> {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) return this.y - o.y;
            else return this.x - o.x;
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Point> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String pos = br.readLine();
            int x = Integer.parseInt(pos.split(" ")[0]);
            int y = Integer.parseInt(pos.split(" ")[1]);
            arr.add(new Point(x, y));
        }

        Collections.sort(arr);
        for (Point p : arr) {
            System.out.println(p.x + " " + p.y);
        }
    }

    public static void change(int[] arr, int idx) {
        int tmp = arr[idx];
        arr[idx] = arr[idx + 1];
        arr[idx + 1] = tmp;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] xPos = new int[n];
        int[] yPos = new int[n];

        for (int i = 0; i < n; i++) {
            String pos = br.readLine();
            xPos[i] = Integer.parseInt(pos.split(" ")[0]);
            yPos[i] = Integer.parseInt(pos.split(" ")[1]);
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (xPos[j] > xPos[j + 1]) {
                    change(xPos, j);
                    change(yPos, j);
                } else if (xPos[j] == xPos[j + 1] && yPos[j] > yPos[j + 1]) {
                    change(xPos, j);
                    change(yPos, j);
                }
            }
        }
        for (int i = 0; i < n; i++) System.out.println(xPos[i] + " " + yPos[i]);
    }
}
