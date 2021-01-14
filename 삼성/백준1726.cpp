#include<bits/stdc++.h>

#define SIZE 102


struct point {
	int x, y, d;
};

int m, n;

// X, 동, 서, 남, 북
int dx[] = { 0,0,0,1,-1 };
int dy[] = { 0,1,-1,0,0 };

int board[SIZE][SIZE];
bool visit[SIZE][SIZE][5];

//dir -> 0: turn left, 1 : turn right
point rotation(point p, int dir) {
	point tmp = p;
	if (dir == 0) {
		if (tmp.d == 1) tmp.d = 4;
		else if (tmp.d == 2) tmp.d = 3;
		else if (tmp.d == 3) tmp.d = 1;
		else tmp.d = 2;
	}
	else {
		if (tmp.d == 1) tmp.d = 3;
		else if (tmp.d == 2) tmp.d = 4;
		else if (tmp.d == 3) tmp.d = 2;
		else tmp.d = 1;
	}
	return tmp;
}

int main() {
	point start, end;
	std::queue<point> q;

	scanf("%d %d", &m, &n);
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%d", &board[i][j]);
		}
	}
	scanf("%d %d %d", &start.x, &start.y, &start.d);
	scanf("%d %d %d", &end.x, &end.y, &end.d);

	start.x--, start.y--, end.x--, end.y--;

	q.push(start);
	visit[start.x][start.y][start.d] = true;

	int count = 0;
	while (!q.empty()) {
		int len = q.size();
		while (len--) {
			point tmp = q.front();
			q.pop();

			if (tmp.x == end.x && tmp.y == end.y && tmp.d == end.d) {
				printf("%d", count);
				return 0;
			}

			//i칸 만큼 move
			for (int i = 1; i < 4; i++) {
				int nx = tmp.x + dx[tmp.d] * i;
				int ny = tmp.y + dy[tmp.d] * i;
				bool flag = false;

				if (nx < 0 || nx >= m || ny < 0 || ny >= n || board[nx][ny] == 1)
					continue;

				for (int j = 1; j <= i; j++) {
					if (board[tmp.x + dx[tmp.d] * j][tmp.y + dy[tmp.d] * j] == 1) {
						flag = true;
						break;
					}
				}

				if (flag == true)
					continue;

				if (visit[nx][ny][tmp.d] == true)
					continue;

				point ntmp = { nx, ny, tmp.d };
				q.push(ntmp);
				visit[ntmp.x][ntmp.y][ntmp.d] = true;
			}

			for (int i = 0; i < 2; i++) {
				point ntmp = rotation(tmp, i);

				if (visit[ntmp.x][ntmp.y][ntmp.d] == true)
					continue;

				q.push(ntmp);
				visit[ntmp.x][ntmp.y][ntmp.d] = true;
			}
		}
		count++;
	}
}