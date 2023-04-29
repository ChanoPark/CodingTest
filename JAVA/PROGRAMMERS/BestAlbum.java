package Programmers;

import java.util.*;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        List<String> orderedGenres = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        while (!map.isEmpty()) {
            String maxGenre = "";
            int maxPlay = 0;

            for (String genre : map.keySet()) {
                if (map.get(genre) > maxPlay) {
                    maxPlay = map.get(genre);
                    maxGenre = genre;
                }
            }
            orderedGenres.add(maxGenre);
            map.remove(maxGenre);
        }

        for (String genre : orderedGenres) {
            List<Music> playList = new ArrayList<>();
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(genre)) {
                    playList.add(new Music(i, plays[i]));
                }
            }
            Collections.sort(playList);
            for (int i = 0; i < 2 && i < playList.size(); i++) {
                answer.add(playList.get(i).id);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static class Music implements Comparable<Music> {
        private int id;
        private int play;

        public Music(int id, int play) {
            this.id = id;
            this.play = play;
        }

        @Override
        public int compareTo(Music o) {
            return o.play - this.play;
        }
    }
}
