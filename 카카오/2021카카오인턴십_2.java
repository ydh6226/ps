import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private int[] dx = new int[]{-1, 0, 1, 0};
    private int[] dy = new int[]{0, 1, 0, -1};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int idx = -1;

        for (String[] place : places) {
            idx++;
            boolean possible = true;

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    char c = place[i].charAt(j);
                    if (c == 'P' && bfs(place, i, j)) {
                        possible = false;
                        break;
                    }
                }
                if (!possible) {
                    break;
                }
            }
            answer[idx] = possible? 1 : 0;
        }
        return answer;
    }

    public boolean bfs(String[] place, int x, int y) {
        boolean[][] visit = new boolean[5][5];
        Queue<int[]> queue = new LinkedList<>();

        visit[x][y] = true;
        queue.add(new int[]{x, y});

        int dis = 0;
        while (!queue.isEmpty()) {
            if (++dis > 2) {
                break;
            }
            int count = queue.size();
            while (--count >= 0) {
                int[] poll = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = poll[0] + dx[i];
                    int ny = poll[1] + dy[i];

                    if (!(0 <= nx && nx < 5 && 0 <= ny && ny < 5 &&
                            place[nx].charAt(ny) != 'X' && !visit[nx][ny])) {
                        continue;
                    }

                    if (place[nx].charAt(ny) == 'P') {
                        return true;
                    }

                    visit[x][y] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return false;
    }
}