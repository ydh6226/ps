#include<bits/stdc++.h>

using namespace std;

//0 길, 1 사과, 2 뱀
int game[102][102];

int main() {
	int n, k, l;
	scanf("%d %d", &n, &k);

	for (int i = 0; i < k; i++) {
		int a, b;
		scanf("%d %d", &a, &b);

		game[a][b] = 1;
	}

	vector < pair<int, char>> dir;
	scanf("%d", &l);
	for (int i = 0; i < l; i++) {
		int a;
		char b;
		scanf("%d %c", &a, &b);
		dir.push_back({ a, b });
	}

	int d = 1;//0123 북동남서
	int dx[] = { -1,0,1,0 };
	int dy[] = { 0,1,0,-1 };
	vector<pair<int, int>> snake = { {1,1} };

	game[1][1] = 2;
	for (int i = 1; ; i++) {
		int hx, hy, tx, ty, nx, ny;
		hx = snake.back().first;
		hy = snake.back().second;
		tx = snake.front().first;
		ty = snake.front().second;

		nx = hx + dx[d];
		ny = hy + dy[d];

		if (nx == 0 || nx == n + 1 || ny == 0 || ny == n + 1 || game[nx][ny] == 2) {
			cout << i << endl;
			break;
		}

		snake.push_back({ nx, ny });

		if (game[nx][ny] != 1) {
			game[tx][ty] = 0;
			snake.erase(snake.begin());
		}

		game[nx][ny] = 2;
		hx = nx;
		hy = ny;

		if (dir.empty() == false && i == dir.front().first) {
			if (dir.front().second == 'D') {
				d = (d + 1) % 4;
			}
			else {
				if (d == 0)
					d = 3;
				else
					d = d - 1;
			}
			dir.erase(dir.begin());
		}
	}
}