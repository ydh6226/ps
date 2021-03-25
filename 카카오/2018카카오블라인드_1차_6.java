import java.util.*;
import java.util.stream.Stream;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        List<List<Character>> boards = new ArrayList<>() {{
            for (int i = 0; i < n; i++) {
                add(new ArrayList<>());
            }
        }};

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                char c = board[i].charAt(j);
                boards.get(j).add(c);
            }
        }

        while (true) {
            Set<List<Integer>> set = new HashSet<>();

            boolean isEnd = true;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < m - 1; j++) {
                    char a = boards.get(i).get(j);
                    char b = boards.get(i).get(j + 1);
                    char c = boards.get(i + 1).get(j);
                    char d = boards.get(i + 1).get(j + 1);

                    if (a != '!' && a == b && b == c && c == d) {
                        for (int u = 0; u < 2; u++) {
                            for (int v = 0; v < 2; v++) {
                                List<Integer> idx = new ArrayList<>();
                                idx.add(i + u);
                                idx.add(j + v);
                                set.add(idx);
                            }
                        }
                        isEnd = false;
                    }
                }
            }

            List<List<Integer>> forDelete = new ArrayList<>(set);
            forDelete.sort(Comparator.comparingInt(a -> a.get(1)));

            int[] dx = new int[n];
            for (List<Integer> list : forDelete) {
                boards.get(list.get(0)).remove(list.get(1) - dx[list.get(0)]);
                dx[list.get(0)]++;
                boards.get(list.get(0)).add('!');
                answer++;
            }

            if (isEnd) {
                return answer;
            }
        }
    }
}