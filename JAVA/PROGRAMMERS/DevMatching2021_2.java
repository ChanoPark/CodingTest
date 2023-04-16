package Programmers;

public class DevMatching2021_2 {
    private static int[][] board;

    public int[] solution(int rows, int columns, int[][] queries) {
        board = new int[rows][columns];
        int[] answer = new int[queries.length];

        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) board[i][j] = num++;
        }


        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(queries[i]);
        }

        return answer;
    }

    public int rotate(int[] d) {
        int sx = d[0] - 1;
        int sy = d[1] - 1;
        int ex = d[2] - 1;
        int ey = d[3] - 1;

        int last = board[sx][sy];
        int temp;
        int min = Integer.MAX_VALUE;

        //오른쪽
        for (int i = sy; i <= ey; i++) {
            min = Math.min(min, board[sx][i]);

            temp = board[sx][i];
            board[sx][i] = last;
            last = temp;
        }

        //아래
        for (int i = sx + 1; i <= ex; i++) {
            min = Math.min(min, board[i][ey]);

            temp = board[i][ey];
            board[i][ey] = last;
            last = temp;
        }

        //왼쪽
        for (int i = ey - 1; i >= sy; i--) {
            min = Math.min(min, board[ex][i]);

            temp = board[ex][i];
            board[ex][i] = last;
            last = temp;
        }

        //위
        for (int i = ex - 1; i >= sx; i--) {
            min = Math.min(min, board[i][sy]);

            temp = board[i][sy];
            board[i][sy] = last;
            last = temp;
        }

        return min;
    }
}
