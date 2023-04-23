package Programmers;

public class IntegerTriangle {
    public int solution(int[][] triangle) {

        for (int i = 1; i < triangle.length; i++) { //i=삼각형 높이
            for (int j = 0; j < triangle[i].length; j++) { //j=가로
                if (j == triangle[i].length - 1) triangle[i][j] += triangle[i - 1][j - 1];
                else if (j == 0) triangle[i][j] += triangle[i - 1][0];
                else triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
            }
        }

        int answer = 0;
        for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
            answer = Math.max(answer, triangle[triangle.length - 1][i]);
        }

        return answer;
    }
}