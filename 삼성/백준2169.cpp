#include<bits/stdc++.h>

#define SIZE 1002
#define MIN -1000000000

int n, m, ans;

int dx[] = { 0,1,0 };
int dy[] = { 1,0,-1 };

int board[SIZE][SIZE];
bool visit[SIZE][SIZE];
int dp[SIZE][SIZE][3];

int dfs(int x, int y, int dir) {
	if (x == n - 1 && y == m - 1)
		return board[x][y];
	//std::cout << "hello";

	if (dp[x][y][dir] == MIN) {
		//오른, 아래, 왼
		int tmp = MIN;
		dp[x][y][dir] = board[x][y];
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny])
				continue;

			visit[nx][ny] = true;
			tmp = std::max(tmp, (dfs(nx, ny, i)));
			visit[nx][ny] = false;
		}
		dp[x][y][dir] += tmp;
	}
	return dp[x][y][dir];
}

int main() {
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%d", &board[i][j]);
			dp[i][j][0]= dp[i][j][1] = dp[i][j][2] = MIN;
		}
	}
	visit[0][0] = true;
	printf("%d", dfs(0, 0, 0));
}