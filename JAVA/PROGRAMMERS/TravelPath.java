package Programmers;

import java.util.*;

public class TravelPath {
    private static boolean[] ch;
    private static List<String> paths = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        String[] answer = {};

        ch = new boolean[tickets.length];

        dfs("ICN", "ICN", tickets, 0);

        Collections.sort(paths);
        return paths.get(0).split(" ");
    }

    private static void dfs(String city, String path, String[][] tickets, int depth) {
        if (depth == tickets.length) {
            paths.add(path);
            return;
        } else {
            for (int i = 0; i < tickets.length; i++) {
                if (!ch[i] && tickets[i][0].equals(city)) {
                    ch[i] = true;
                    dfs(tickets[i][1], path + " " + tickets[i][1], tickets, depth + 1);
                    ch[i] = false;
                }
            }
        }
    }
}
