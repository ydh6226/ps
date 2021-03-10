class Solution {
    int size;
    int[][] map;

    public int solution(int[][] board) {
        int answer = 0;
        size = board.length;
        map = board;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 0) {
                    continue;
                }

                if (isA(i, j)) {
                    if (drop(i, j + 1) && drop(i, j + 2)) {
                        remove(i, j, i + 1, j, i + 1, j + 1, i + 1, j + 2);
                        answer++;
                        j = -1;
                    }
                } else if (isB(i, j)) {
                    if (drop(i, j - 1)) {
                        remove(i, j, i + 1, j, i + 2, j, i + 2, j - 1);
                        answer++;
                        j = -1;
                    }
                } else if (isC(i, j)) {
                    if (drop(i, j - 1) && drop(i, j - 2)) {
                        remove(i, j, i + 1, j, i + 1, j - 1, i + 1, j - 2);
                        answer++;
                        j = -1;
                    }
                } else if (isD(i, j)) {
                    if (drop(i, j + 1) && drop(i, j - 1)) {
                        remove(i, j, i + 1, j, i + 1, j + 1, i + 1, j - 1);
                        answer++;
                        j = -1;
                    }
                } else if (isE(i, j)) {
                    if (drop(i, j + 1)) {
                        remove(i, j, i + 1, j, i + 2, j, i + 2, j + 1);
                        answer++;
                        j = -1;
                    }
                }
            }
        }
        return answer;
    }

    private void remove(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        map[x1][y1] = 0;
        map[x2][y2] = 0;
        map[x3][y3] = 0;
        map[x4][y4] = 0;
    }

    private boolean drop(int x, int y) {
        for (int i = 0; i < x; i++) {
            if (map[i][y] != 0)
                return false;
        }
        return true;
    }

    private boolean isA(int x, int y) {
        if (x + 1 >= size || y + 2 >= size)
            return false;

        int number = map[x][y];
        return map[x + 1][y] == number && map[x + 1][y + 1] == number && map[x + 1][y + 2] == number
                && map[x][y + 1] == 0 && map[x][y + 2] == 0;
    }

    private boolean isB(int x, int y) {
        if (x + 2 >= size || y - 1 < 0)
            return false;

        int number = map[x][y];
        return map[x + 1][y] == number && map[x + 2][y] == number && map[x + 2][y - 1] == number
                && map[x][y - 1] == 0 && map[x + 1][y - 1] == 0;
    }

    private boolean isC(int x, int y) {
        if (x + 1 >= size || y - 2 < 0)
            return false;

        int number = map[x][y];
        return map[x + 1][y] == number && map[x + 1][y - 1] == number && map[x + 1][y - 2] == number
                && map[x][y - 1] == 0 && map[x][y - 2] == 0;
    }

    private boolean isD(int x, int y) {
        if (x + 1 >= size || y + 1 >= size || y - 1 < 0)
            return false;

        int number = map[x][y];
        return map[x + 1][y] == number && map[x + 1][y + 1] == number && map[x + 1][y - 1] == number
                && map[x][y + 1] == 0 && map[x][y - 1] == 0;
    }

    private boolean isE(int x, int y) {
        if (x + 2 >= size || y + 1 >= size)
            return false;

        int number = map[x][y];
        return map[x + 1][y] == number && map[x + 2][y] == number && map[x + 2][y + 1] == number
                && map[x][y + 1] == 0 && map[x + 1][y + 1] == 0;
    }

}