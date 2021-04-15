class Solution {
    int answer = 0;
    int size;
    int[] location;

    public int solution(int n) {
        size = n;
        for (int i = 0; i < size / 2; i++) {
            location = new int[size];
            location[0] = i;
            dfs(1);
        }
        answer *= 2;
        if (size % 2 == 1) {
            location = new int[size];
            location[0] = size/2;
            dfs(1);
        }

        return answer;
    }

    private void dfs(int row) {
        if (row == size) {
            answer++;
            return;
        }

        for (int i = 0; i < size; i++) {
            if (isPossible(row, i)) {
                location[row] = i;
                dfs(row + 1);
            }
        }
    }

    private boolean isPossible(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (location[i] == col) {
                return false;
            }
            if ((row - i) == (Math.abs(col - location[i]))) {
                return false;
            }
        }
        return true;
    }
}