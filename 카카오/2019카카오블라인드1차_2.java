import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] numStagePeople = new int[N + 2];

        for (int stage : stages) {
            numStagePeople[stage] += 1;
        }

        int numRemainPeople = stages.length;
        List<Game> games = new ArrayList<>();

        for (int i = 1; i <= N ; i++) {
            double rate = (double) numStagePeople[i] / numRemainPeople;
            numRemainPeople -= numStagePeople[i];

            games.add(new Game(i, rate));
        }

        Collections.sort(games);
        int idx=0;
        for (Game game : games) {
            answer[idx++] = game.stage;
        }
        return answer;
    }

    static class Game implements Comparable<Game> {
        int stage;
        double rate;

        public Game(int stage, double rate) {
            this.stage = stage;
            this.rate = rate;
        }

        @Override
        public int compareTo(Game o) {
            if (rate > o.rate) {
                return -1;
            } else if (rate < o.rate) {
                return 1;
            } else {
                return Integer.compare(stage, o.stage);
            }
        }
    }
}