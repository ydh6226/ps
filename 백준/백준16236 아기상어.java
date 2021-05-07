import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        int[] fishes = new int[7];

        int sharkX = 0;
        int sharkY = 0;
        int sharkSize = 2;
        int growthCount = 2;
        int eatableFishCount = 0;

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(split[j]);
                switch (num) {
                    case 0:
                        break;
                    case 9:
                        sharkX = i;
                        sharkY = j;
                        break;
                    case 1:
                        eatableFishCount++;
                    default:
                        fishes[num]++;
                        graph[i][j] = num;
                }
            }
        }

        int[] dx = {-1 ,0, 0, 1};
        int[] dy = {0 ,-1, 1, 0};

        boolean[][] visit = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        visit[sharkX][sharkY] = true;
        queue.add(new int[]{sharkX, sharkY});

        if (eatableFishCount == 0) {
            System.out.println(0);
            return;
        }

        int answer = 0;
        int moveCount = 0;
        while (!queue.isEmpty()) {
            int loopCount = queue.size();
            moveCount++;

            List<int[]> possibleFishes = new ArrayList<>();
            while (loopCount-- > 0) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (!(0 <= nx && nx < n && 0 <= ny && ny < n &&
                            !visit[nx][ny] && sharkSize >= graph[nx][ny])) {
                        continue;
                    }

                    if (graph[nx][ny] == 0 || graph[nx][ny] == sharkSize) {
                        visit[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        continue;
                    }
                    //물고기 먹는 경우
                    possibleFishes.add(new int[]{nx, ny});
                }
            }

            if (!possibleFishes.isEmpty()) {
                answer = moveCount;
                possibleFishes.sort(new MyComparator());
                int[] fish = possibleFishes.get(0);
                int x = fish[0];
                int y = fish[1];

                graph[x][y] = 0;
                eatableFishCount--;
                queue.clear();

                if (--growthCount == 0 && sharkSize <= 6) {
                    growthCount = ++sharkSize;
                    eatableFishCount += fishes[sharkSize - 1];
                }

                if (eatableFishCount != 0) {
                    queue.add(new int[]{x, y});
                    arrayFillFalse(visit);
                    visit[x][y] = true;
                }
            }
        }
        System.out.println(answer);
    }

    private static void arrayFillFalse(boolean[][] visits) {
        for (boolean[] visit : visits) {
            Arrays.fill(visit, false);
        }
    }

    private static class MyComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        }
    }
}
