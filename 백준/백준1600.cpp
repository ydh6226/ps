#include<bits/stdc++.h>

#define SIZE 202

struct monkey{
	int x, y, k;
};

int board[SIZE][SIZE];
bool visited[SIZE][SIZE][32];

//상하좌우 + 말처럼 이동 1시부터 시계방향으로
int dx[] = { -1,1,0,0, -2,-1,1,2,2,1,-1,-2 };
int dy[] = { 0,0, -1,1, 1,2,2,1,-1,-2,-2,-1 };

int main() {
	int k, w, h;
	std::queue<monkey> q;
	scanf("%d %d %d", &k, &w, &h);

	for (int i = 0; i < h; i++) {
		for (int j = 0; j < w; j++) {
			scanf("%d", &board[i][j]);
		}
	}
	
	monkey m;
	m.x = 0, m.y = 0, m.k = 0;
	visited[m.x][m.y][m.k] = true;
	q.push(m);

	int count = 0;
	while (!q.empty()) {
		int len = q.size();
		printf("");
		while (len--) {
			monkey tmp = q.front();
			q.pop();

			if (tmp.x == h - 1 && tmp.y == w - 1) {
				printf("%d", count);
				return 0;
			}

			for (int i = 0; i < 12; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				int nk = (i >= 4 ? tmp.k + 1:tmp.k);
				if (i >= 4 && tmp.k >= k)
					continue;

				if (nx < 0 || nx >= h || ny < 0 || ny >= w)
					continue;

				if (board[nx][ny] == 1)
					continue;

				if (visited[nx][ny][nk] == true)
					continue;

				monkey ntmp;
				ntmp.x = nx;
				ntmp.y = ny;
				ntmp.k = nk;
				
				visited[ntmp.x][ntmp.y][ntmp.k] = true;
				q.push(ntmp);
			}
		}
		count++;
	}
	printf("-1");
}
