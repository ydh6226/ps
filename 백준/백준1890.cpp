#include<bits/stdc++.h>

#define SIZE 102
using ll = long long;

int n;
ll ans;

int dx[] = { 0, 1 };
int dy[] = { 1, 0 };

int board[SIZE][SIZE];
ll dp[SIZE][SIZE];

ll dfs(int x, int y) {
	if (x == n - 1 && y == n - 1)
		return 1;

	if (dp[x][y] == -1) {
		dp[x][y] = 0;
		for (int i = 0; i < 2; i++) {
			int nx = x + dx[i] * board[x][y];
			int ny = y + dy[i] * board[x][y];

			if (nx < 0 || nx >= n || ny < 0 || ny >= n)
				continue;

			dp[x][y] += dfs(nx, ny);
		}
	}
	return dp[x][y];
}

int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%d", &board[i][j]);
			dp[i][j] = -1;
		}
	}
	printf("%d", dfs(0, 0));
}