package Programmers;

import java.util.*;

/**
 * 2023 KAKAO BLIND RECRUITMENT
 * Lv.1 개인정보 수집 유효 기간
 */
public class Kakao2023Blind_1 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();

        String[] todayArr = today.split("\\.");
        int ty = Integer.parseInt(todayArr[0]);
        int tm = Integer.parseInt(todayArr[1]);
        int td = Integer.parseInt(todayArr[2]);

        Map<String, Integer> termMap = new HashMap<>();
        for (String s : terms) {
            String[] t = s.split(" ");
            termMap.put(t[0], Integer.parseInt(t[1]));
        }

        int idx = 1;
        for (String privacy : privacies) {
            String[] temp = privacy.split(" ");
            String[] date = temp[0].split("\\.");
            String term = temp[1];

            int y = Integer.parseInt(date[0]);
            int m = Integer.parseInt(date[1]);
            int d = Integer.parseInt(date[2]);

            y += termMap.get(term) / 12;
            m += termMap.get(term) % 12;
            if (m > 12) {
                y += m / 12;
                m %= 12;
            }

            //수집 날짜 + 정책 날짜 < 오늘 날짜 -> list 추가
            if (ty > y) {
                list.add(idx);
            } else if (ty == y) {
                //연도는 같음
                if (tm > m) {
                    list.add(idx);
                } else if (tm == m) {
                    if (td >= d) list.add(idx);
                }
            }

            idx++;
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }

    public static int[] betterSolution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();

        int todayValue = getDate(today);

        Map<String, Integer> termMap = new HashMap<>();
        for (String s : terms) {
            String[] t = s.split(" ");
            termMap.put(t[0], Integer.parseInt(t[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");

            if (getDate(privacy[0]) + (termMap.get(privacy[1]) * 28) <= todayValue) {
                list.add(i+1);
            }
        }

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static int getDate(String date) {
        String[] dateArr = date.split("\\.");
        int year = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int day = Integer.parseInt(dateArr[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}
