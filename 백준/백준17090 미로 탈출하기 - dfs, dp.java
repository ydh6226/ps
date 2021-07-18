import java.io.*;

public class Main {
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static int[][] map;
    private static Boolean[][] possible; //null일경우 아직 탐색하지 않은 곳
    private static boolean[][] visit;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        map = new int[n][m];
        possible = new Boolean[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String mapInputs = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = getDirection(mapInputs.charAt(j));
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    private static boolean dfs(int x, int y) {
        if (possible[x][y] != null) {
            return possible[x][y];
        }

        if (visit[x][y]) {
            return false;
        }

        int nx = x + dx[map[x][y]];
        int ny = y + dy[map[x][y]];

        if (!(0 <= nx && nx < n && 0 <= ny && ny < m)) {
            return true;
        }

        visit[x][y] = true;
        possible[x][y] = dfs(nx, ny);
        visit[x][y] = false;
        return possible[x][y];
    }

    private static int getDirection(char c) {
        switch (c) {
            case 'U':
                return 0;
            case 'R':
                return 1;
            case 'D':
                return 2;
            default:
                return 3;
        }
    }
}