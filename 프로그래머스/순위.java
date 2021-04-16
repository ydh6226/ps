class Solution {
    boolean[][] graph;

    public int solution(int n, int[][] results) {
        graph = new boolean[n + 1][n + 1];

        for (int[] result : results) {
            graph[result[0]][result[1]] = true;
        }

        for (int m = 1; m <= n; m++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][m] && graph[m][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] || graph[j][i]) {
                    count++;
                }
            }
            if (count == n - 1) {
                answer++;
            }
        }
        return answer;
    }
}