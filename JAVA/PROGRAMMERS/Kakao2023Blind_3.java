package Programmers;

import java.util.Arrays;

public class Kakao2023Blind_3 {
    private static int[][] users;
    private static int[] emoticons;
    private static int[] disEmoticons;
    private static int[] discounts;
    private static int[] percents;

    private static int sum = 0;
    private static int member = 0;

    public static void main(String[] args) {
        Kakao2023Blind_3 s = new Kakao2023Blind_3();
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emo = {7000, 9000};
        System.out.println(Arrays.toString(s.solution(users, emo)));
    }

    public int[] solution(int[][] userList, int[] emoticonList) {
        users = userList;
        emoticons = emoticonList;
        disEmoticons = new int[emoticonList.length];
        discounts = new int[emoticonList.length];
        percents = new int[]{10, 20, 30, 40};

        dfs(0);
        return new int[]{member, sum};
    }

    private void dfs(int idx) {
        if (idx == emoticons.length) {
            int[] userSum = new int[users.length];
            int tempSum = 0;
            int tempMember = 0;

            for (int i = 0; i < disEmoticons.length; i++) {
                for (int j = 0; j < users.length; j++) {
                    if (users[j][0] <= discounts[i]) userSum[j] += disEmoticons[i];
                }
            }

            for (int i = 0; i < userSum.length; i++) {
                if (userSum[i] >= users[i][1]) tempMember++;
                else tempSum += userSum[i];
            }

            if (member < tempMember) {
                member = tempMember;
                sum = tempSum;
            } else if (member == tempMember) {
                sum = Math.max(sum, tempSum);
            }
        } else {
            for (int i = 0; i < 4; i++) {
                discounts[idx] = (i + 1) * 10;
                disEmoticons[idx] = emoticons[idx] * (100 - percents[i]) / 100;
                dfs(idx + 1);
            }
        }
    }
}
