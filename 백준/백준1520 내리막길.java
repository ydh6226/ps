import java.io.*;
import java.util.Arrays;


class Main {
    private static final int[] dx = {-1 ,0, 1, 0};
    private static final int[] dy = {0 ,1, 0, -1};
    private static int[][] board;
    private static int[][] dp;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sizeInput = br.readLine().split(" ");
        n = Integer.parseInt(sizeInput[0]);
        m = Integer.parseInt(sizeInput[1]);

        board = new int[n][m];
        dp = new int[n][m];

        for (int[] d : dp) {
            Arrays.fill(d , -1);
        }

        for (int i = 0; i < n; i++) {
            String[] boardInput = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(boardInput[j]);
            }
        }
        System.out.println(dfs(0, 0));
    }

    private static int dfs(int x, int y) {
        if (x == n - 1 && y == m - 1) {
            return 1;
        }

        if (dp[x][y] == -1) {
            dp[x][y] = 0;
            for (int i = 0; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || board[x][y] <= board[nx][ny]) {
                    continue;
                }

                dp[x][y] += dfs(nx, ny);
            }
        }
        return dp[x][y];
    }
}
