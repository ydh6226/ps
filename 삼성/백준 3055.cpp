#include<bits/stdc++.h>

#define SIZE 52

using namespace std;

struct point {
	int x, y;
};

int r, c;
char board[SIZE][SIZE];
queue<point> waterQ;

int dx[] = { -1,0,1,0 };
int dy[] = { 0,1,0,-1 };

void water() {
	int len = waterQ.size();
	while (len--) {
		point tmp = waterQ.front();
		waterQ.pop();

		for (int i = 0; i < 4; i++) {
			int nx = tmp.x + dx[i];
			int ny = tmp.y + dy[i];

			if (nx < 0 || nx >= r || ny < 0 || ny >= c || board[nx][ny] == 'D' || board[nx][ny] == '*' || board[nx][ny] == 'X')
				continue;

			point ntmp = { nx, ny };
			waterQ.push(ntmp);
			board[ntmp.x][ntmp.y] = '*';
		}
	}
}

int main() {
	queue<point> q;
	bool visit[SIZE][SIZE] = { 0 };

	scanf("%d %d", &r, &c);
	for (int i = 0; i < r; i++) {
		scanf("%s", &board[i]);
		for (int j = 0; j < c; j++) {
			char cc = board[i][j];
			if (cc == 'S') {
				point tmp = { i, j };
				q.push(tmp);
				visit[tmp.x][tmp.y] = true;
				board[i][j] = '.';
			}
			else if (cc == '*') {
				point tmp;
				tmp.x = i, tmp.y = j;
				waterQ.push(tmp);
			}
		}
	}

	int count = 0;
	while (!q.empty()) {
		int len = q.size();
		water();
		while (len--) {
			point tmp = q.front();
			q.pop();

			if (board[tmp.x][tmp.y] == 'D') {
				printf("%d", count);
				return 0;
			}

			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];

				if (nx < 0 || nx >= r || ny < 0 || ny >= c || board[nx][ny] == '*' || board[nx][ny] == 'X')
					continue;

				if (visit[nx][ny] == true)
					continue;

				point ntmp = { nx, ny };
				q.push(ntmp);
				visit[ntmp.x][ntmp.y] = true;
			}
		}
		count++;
	}
	printf("KAKTUS");
}