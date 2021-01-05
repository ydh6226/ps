#include<bits/stdc++.h>
#define SIZE 52

struct tree {
	int d; //0 가로, 1 세로
	int x, y;
};

int size;
char board[SIZE][SIZE];
bool visit[2][SIZE][SIZE];

//상하좌우
int dx[] = {-1,1,0,0 };
int dy[] = { 0,0,-1,1 };

bool possi(tree t, int i) {
	int d = t.d;
	int x = t.x;
	int y = t.y;

	//이동
	if (i < 4) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (d == 0) {
			if (nx < 0 || nx >= size || ny - 1 < 0 || ny + 1 >= size)
				return false;

			if (!(board[nx][ny - 1] == '0' && board[nx][ny] == '0' && board[nx][ny + 1] == '0'))
				return false;
		}
		else {
			if (nx - 1 < 0 || nx + 1 >= size || ny < 0 || ny >= size)
				return false;

			if (!(board[nx - 1][ny] == '0' && board[nx][ny] == '0' && board[nx + 1][ny] == '0'))
				return false;
		}
	}
	//회전
	else {
		//가로
		if (d == 0) {
			if (x - 1 < 0 || x + 1 >= size)
				return false;

			if (!(board[x - 1][y - 1] == '0' && board[x - 1][y] == '0' && board[x - 1][y + 1] == '0'
				&& board[x + 1][y - 1] == '0' && board[x + 1][y] == '0' && board[x + 1][y + 1] == '0'))
				return false;

		}
		//세로
		else {
			if (y - 1 < 0 || y + 1 >= size)
				return false;

			if (!(board[x - 1][y - 1] == '0' && board[x][y - 1] == '0' && board[x + 1][y - 1] == '0'
				&& board[x - 1][y + 1] == '0' && board[x][y + 1] == '0' && board[x + 1][y + 1] == '0'))
				return false;
		}
	}
	return true;
}

int main() {
	scanf("%d", &size);
	std::vector<std::pair<int, int>> btree;
	std::vector<std::pair<int, int>> etree;
	std::queue < tree > q;
	tree bt, et;

	for (int i = 0; i < size; i++) {
		scanf("%s", &board[i]);
		for (int j = 0; j < size; j++) {
			if (board[i][j] == 'B') {
				btree.push_back({ i,j });
				board[i][j] = '0';
			}
			else if (board[i][j] == 'E') {
				etree.push_back({ i,j });
				board[i][j] = '0';
			}
		}
	}

	bt.x = btree[1].first;
	bt.y = btree[1].second;
	bt.d = (btree[0].first == btree[1].first && btree[1].first == btree[2].first) ? 0 : 1;

	et.x = etree[1].first;
	et.y = etree[1].second;
	et.d = (etree[0].first == etree[1].first && etree[1].first == etree[2].first) ? 0 : 1;

	visit[bt.d][bt.x][bt.y] = true;
	q.push(bt);

	int count = 0;
	while (!q.empty()) {
		int len = q.size();
		while (len--) {
			tree tmp = q.front();
			q.pop();

			if (tmp.d == et.d && tmp.x == et.x && tmp.y == et.y) {
				printf("%d", count);
				return 0;
			}

			for (int i = 0; i < 5; i++) {
				if (!possi(tmp, i))
					continue;

				tree ntmp;
				//이동
				if (i < 4) {
					ntmp.d = tmp.d;
					ntmp.x = tmp.x + dx[i];
					ntmp.y = tmp.y + dy[i];
				}
				//회전
				else {
					ntmp.d = (tmp.d == 0 ? 1 : 0);
					ntmp.x = tmp.x;
					ntmp.y = tmp.y;
				}

				if (visit[ntmp.d][ntmp.x][ntmp.y] == true)
					continue;

				visit[ntmp.d][ntmp.x][ntmp.y] = true;
				q.push(ntmp);
			}
		}
		count++;
	}
	printf("0");
	return 0;
}