import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, List<Music>> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            countMap.put(genre, countMap.getOrDefault(genre, 0) + play);

            if (!map.containsKey(genre)) {
                map.put(genre, new ArrayList<>());
            }

            List<Music> musicList = map.get(genre);
            musicList.add(new Music(play, i));
        }

        List<String> collect = countMap.entrySet()
                .stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<Integer> answer = new ArrayList<>();
        for (String name : collect) {
            List<Music> musicList = map.get(name);
            Collections.sort(musicList);

            for (int i = 0; i < musicList.size(); i++) {
                answer.add(musicList.get(i).id);
                if (i == 1) {
                    break;
                }
            }
        }


        int[] ans = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }
        return ans;
    }

    static class Music implements Comparable<Music> {
        int play;
        int id;

        public Music(int play, int id) {
            this.play = play;
            this.id = id;
        }

        @Override
        public int compareTo(Music o) {
            if (this.play == o.play) {
                return Integer.compare(this.id, o.id);
            }
            return Integer.compare(o.play, this.play);
        }
    }
}