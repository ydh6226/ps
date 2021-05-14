import java.awt.print.Pageable;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        char[][] graph = new char[n][m];
        boolean[][][] visit = new boolean[n][m][64];

        int sx = 0;
        int sy = 0;

        for (int i = 0; i < n; i++) {
            String graphInput = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = graphInput.charAt(j);
                if (graph[i][j] == '0') {
                    sx = i;
                    sy = j;
                    graph[i][j] = '.';
                }
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int answer = -1;

        Queue<Move> moves = new LinkedList<>();
        moves.add(new Move(sx, sy, 0, 0));
        visit[sx][sy][0] = true;

        while (!moves.isEmpty()) {
            Move move = moves.poll();
            if (graph[move.x][move.y] == '1') {
                answer = move.v;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = move.x + dx[i];
                int ny = move.y + dy[i];
                int nv = move.v + 1;
                int nKeys = move.keys;

                if (!(0 <= nx && nx < n && 0 <= ny && ny < m && graph[nx][ny] != '#')) {
                    continue;
                }

                char graphElement = graph[nx][ny];
                if (Character.isLetter(graphElement)) {
                    if (Character.isLowerCase(graphElement)) {
                        nKeys = getAddedKey(graphElement - 'a', nKeys);
                    } else if (Character.isUpperCase(graphElement) && !isContainsKey(graphElement - 'A', nKeys)) {
                        continue;
                    }
                }

                if (visit[nx][ny][nKeys]) {
                    continue;
                }

                moves.add(new Move(nx, ny, nv, nKeys));
                visit[nx][ny][nKeys] = true;
            }
        }
        System.out.println(answer);
    }

    private static int getAddedKey(int key, int keys) {
        int i = keys | (1 << key);
        return i;
    }

    private static boolean isContainsKey(int key, int keys) {
        boolean b = (keys & (1 << key)) > 0;
        return b;
    }

    private static class Move {
        int x;
        int y;
        int v;
        int keys;

        public Move(int x, int y, int v, int keys) {
            this.x = x;
            this.y = y;
            this.v = v;
            this.keys = keys;
        }
    }
}
