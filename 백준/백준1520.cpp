#include<bits/stdc++.h>

#define SIZE 502

int n, m, ans;

int dx[] = { -1, 0, 1, 0 };
int dy[] = { 0, 1, 0, -1 };

int board[SIZE][SIZE];
int dp[SIZE][SIZE];

int dfs(int x, int y) {
	if (x == n - 1 && y == m - 1)
		return 1;

	if (dp[x][y] == -1) {
		dp[x][y] = 0;

		int tmp = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= n || y < 0 || y >= m || board[nx][ny] >= board[x][y])
				continue;
			
			dp[x][y] += dfs(nx, ny);
		}
	}
	return dp[x][y];
}

int main() {
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%d", &board[i][j]);
			dp[i][j] = -1;
		}
	}
	printf("%d", dfs(0, 0));
}