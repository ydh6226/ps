#include<bits/stdc++.h>
#define SIZE 102

struct point {
	int x, y;
};

int n, m;
int board[SIZE][SIZE];

int dx[] = { -1,0,1,0 };
int dy[] = { 0,1,0,-1 };

bool bfs(int x, int y) {
	std::queue<point> q;
	bool visit[SIZE][SIZE] = { 0 };

	point p;
	p.x = x, p.y = y;

	q.push(p);
	visit[p.x][p.y] = true;

	int count = 0;
	while (!q.empty()) {
		point tmp = q.front();
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = tmp.x + dx[i];
			int ny = tmp.y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m)
				continue;

			if (board[nx][ny] == 0) {
				if (visit[nx][ny] == true)
					continue;

				point ntmp;
				ntmp.x = nx, ntmp.y = ny;

				q.push(ntmp);
				visit[ntmp.x][ntmp.y] = true;
			}
			else {

				board[nx][ny]++;
				count++;
			}
		}
	}

	if (count == 0)
		return false;
	return true;
}

void melting() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (board[i][j] == 0)
				continue;

			if (board[i][j] >= 3) {
				board[i][j] = 0;
			}
			else if (board[i][j] == 2) {
				board[i][j] = 1;
			}
		}
	}
}

int main() {
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%d", &board[i][j]);
		}
	}

	int ans = 0;
	while (true) {
		if (!bfs(0, 0))
			break;
		melting();
		ans++;
	}
	printf("%d", ans);
}