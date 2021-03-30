import java.util.Arrays;

class Solution {
    private static final int inf = 10000000;
    int[][] board = new int[201][201];

    public int solution(int n, int s, int a, int b, int[][] fares) {
        for (int[] ints : board) {
            Arrays.fill(ints, inf);
        }

        for (int i = 1; i <= n ; i++) {
            board[i][i] = 0;
        }

        for (int[] fare : fares) {
            board[fare[0]][fare[1]] = fare[2]; 
            board[fare[1]][fare[0]] = fare[2]; 
        }

        for (int k = 1; k <= n ; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (board[i][j] > board[i][k] + board[k][j]) {
                        board[i][j] = board[i][k] + board[k][j];
                    }
                }
            }
        }

        int answer = inf;

        for (int i = 1; i <= n ; i++) {
            answer = Math.min(answer, Math.min(board[s][a] + board[s][b], board[s][i] + board[i][a] + board[i][b]));
        }

        return answer;
    }
}