package Programmers;

public class FoodFightContest {
    public static void main(String[] args) {
        FoodFightContest f = new FoodFightContest();
        f.solution(new int[]{1, 3, 4, 6});
    }

    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int size = food.length;
        for (int i = 1; i < size; i++) {
            int cnt = food[i] / 2;
            sb.append(String.valueOf(i).repeat(Math.max(0, cnt)));
        }
        answer = sb + "0" + sb.reverse();
        return answer;
    }
}
