package softeer;

import java.util.*;
import java.io.*;

public class ObstacleProgram {
    private final static int[] dx = {-1, 0, 1, 0};
    private final static int[] dy = {0, 1, 0, -1};
    private static int n;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                arr[i][j] = Character.getNumericValue(chars[j]);
            }
        }

        int cnt = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    list.add(dfs(arr, j, i, 0));
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for (Integer x : list) {
            System.out.println(x);
        }

    }

    public static int dfs(int[][] arr, int x, int y, int level) {
        arr[y][x] = 0;
        level++;
        for (int i = 0; i < 4; i++) {
            if (x + dx[i] >= 0 && y + dy[i] >= 0 && x + dx[i] < n && y + dy[i] < n && arr[y + dy[i]][x + dx[i]] == 1) {

                level = dfs(arr, x + dx[i], y + dy[i], level);
            }
        }
        return level;
    }
}
