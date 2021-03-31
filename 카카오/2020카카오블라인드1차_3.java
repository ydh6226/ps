import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Solution {
    //n:keySize, m:lockSize
    private int n;
    private int m;

    int[][] board;
    private List<int[][]> keys = new ArrayList<>();

    public boolean solution(int[][] key, int[][] lock) {
        n = key.length;
        m = lock.length;
        board = new int[m * 3][m * 3];

        for (int i = m; i < 2 * m; i++) {
            for (int j = m; j < 2 * m; j++) {
                board[i][j] = lock[i-m][j-m];
            }
        }

        for (int i = 0; i < 4; i++) {
            key = rotation(key);
            keys.add(key);
        }

        for (int i = 0; i <= 2 * m ; i++) {
            for (int j = 0; j <= 2 * m; j++) {
                for (int[][] k : keys) {
                    if (isPossible(k, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int[][] rotation(int[][] key) {
        int[][] tmp = new int[n][n];

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                tmp[j][n - i - 1] = key[i][j];
            }
        }
        return tmp;
    }

    private boolean isPossible(int[][] key, int x, int y) {
        int[][] tmp = new int[board.length][board.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = board[i].clone();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i + x][j + y] += key[i][j];
            }
        }

        for (int i = m; i < 2 * m; i++) {
            for (int j = m; j < 2 * m; j++) {
                if (tmp[i][j] != 1)
                    return false;
            }
        }

        return true;
    }
}