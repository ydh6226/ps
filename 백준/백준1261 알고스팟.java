import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[1]);
        int m = Integer.parseInt(split[0]);

        int[][] board = new int[n][m];
        boolean[][] visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0,0,0));
        visit[0][0] = true;

        int answer = 0;
        while (!pq.isEmpty()) {
            Point poll = pq.poll();
            int x = poll.x;
            int y = poll.y;
            int c = poll.count;

            if (x == n - 1 && y == m - 1) {
                answer = c;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nc = c;

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny]) {
                    continue;
                }

                if (board[nx][ny] == 1) {
                    nc++;
                }

                pq.add(new Point(nx, ny, nc));
                visit[nx][ny] = true;
            }
        }
        System.out.println(answer);
    }

    private static class Point implements Comparable<Point>{
        int x;
        int y;
        int count;
        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.count, o.count);
        }
    }

}
