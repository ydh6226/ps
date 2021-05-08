import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String graphInputs = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = Character.getNumericValue(graphInputs.charAt(j));
            }
        }


        int[] dx = {-1, 0 ,1 ,0};
        int[] dy = {0, 1 ,0 ,-1};
        boolean[][] visit = new boolean[n][m];

        int moveCount = 0;
        Queue<int []> moves = new LinkedList<>();
        moves.add(new int[]{0, 0});
        visit[0][0] = true;

        while (!moves.isEmpty()) {
            int iterCount = moves.size();
            moveCount++;
            while (iterCount-- > 0) {
                int[] node = moves.poll();
                int x = node[0];
                int y = node[1];

                if (x == n - 1 && y == m - 1) {
                    System.out.println(moveCount);
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (!(0 <= nx && nx < n && 0 <= ny && ny < m && !visit[nx][ny] && graph[nx][ny] == 1)) {
                        continue;
                    }

                    moves.add(new int[]{nx, ny});
                    visit[nx][ny] = true;
                }
            }
        }
    }
}
