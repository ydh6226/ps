#include<bits/stdc++.h>

#define SIZE 30
char board[SIZE][SIZE];
char pipe[] = { '|','-','+','1','2','3','4' };
std::vector<std::vector<char>> dic_pipe = {
	{'|', '-', '1', '4'},
	{'-', '+', '3', '4'},
	{'|', '+', '3', '2'},
	{'-', '+', '2', '1'}
};
int dx[] = { -1, 0, 1, 0 };
int dy[] = { 0, 1, 0, -1 };

bool move(int& x, int& y, int& ox, int& oy);

int main() {
	int r, c, mx, my, zx, zy, smx, smy, szx, szy, emx, emy, ezx, ezy;
	int ans_x, ans_y;
	int count = 0;

	scanf("%d %d", &r, &c);

	for (int i = 0; i < r; i++) {
		scanf("%s", &board[i]);
		for (int j = 0; j < c; j++) {
			if (board[i][j] == 'M')
				mx = i, my = j;
			else if (board[i][j] == 'Z')
				zx = i, zy = j;
			else if (board[i][j] == '+')
				count += 2;
			else if (board[i][j] != '.')
				count++;
		}
	}
	
	for (int i = 0; i < 4; i++) {
		int nx = mx + dx[i];
		int ny = my + dy[i];

		if (nx < 0 || nx >= r || ny < 0 || ny >= c)
			continue;

		if (find(dic_pipe[i].begin(), dic_pipe[i].end(), board[nx][ny]) != dic_pipe[i].end()) {
			smx = nx;
			smy = ny;
			break;
		}
	}

	count--;

	while (true) {
		move(smx, smy, mx, my);
		count--;

		if (board[smx][smy] == '.') {
			emx = mx, emy = my;
			ans_x = smx + 1, ans_y = smy + 1;
			break;
		}
	}

	for (int i = 0; i < 7; i++) {
		int nx, ny, ox, oy;
		nx = smx;
		ny = smy;
		ox = mx;
		oy = my;

		int ctmp = count;
		board[nx][ny] = pipe[i];
		ctmp += (board[nx][ny] == '+' ? 2 : 1);
		
		while (true) {
			if (!move(nx, ny, ox, oy))
				break;

			if (board[nx][ny] == '.') {
				break;
			}
			else if (ctmp == 0) {
				if (board[nx][ny] == 'Z') {
					printf("%d %d %c", ans_x, ans_y, pipe[i]);
					return 0;
				}
				else {
					break;
				}
			}

			ctmp--;
		}
	}

}

bool move(int& x, int& y, int &ox, int &oy) {
	int nx, ny;
	char c = board[x][y];

	if (c == '|') {
		if (x < ox)
			nx = x + dx[0], ny = y + dy[0];
		else if (x > ox)
			nx = x + dx[2], ny = y + dy[2];
		else
			return false;
	}
	else if (c == '-') {
		if (y < oy)
			nx = x + dx[3], ny = y + dy[3];
		else if (y > oy)
			nx = x + dx[1], ny = y + dy[1];
		else
			return false;
	}
	else if (c == '+') {
		if (x < ox)
			nx = x + dx[0], ny = y + dy[0];
		else if (x > ox)
			nx = x + dx[2], ny = y + dy[2];
		else if (y < oy)
			nx = x + dx[3], ny = y + dy[3];
		else if (y > oy)
			nx = x + dx[1], ny = y + dy[1];
	}
	else if (c == '1') {
		if (x < ox)
			nx = x + dx[1], ny = y + dy[1];
		else if (y < oy)
			nx = x + dx[2], ny = y + dy[2];
		else
			return false;
	}
	else if (c == '2') {
		//
		if (x > ox)
			nx = x + dx[1], ny = y + dy[1];
		else if (y < oy)
			nx = x + dx[0], ny = y + dy[0];
		else
			return false;
	}
	else if (c == '3') {
		if (x > ox)
			nx = x + dx[3], ny = y + dy[3];
		else if (y > oy)
			nx = x + dx[0], ny = y + dy[0];
		else
			return false;
	}
	else if (c == '4') {
		if (x < ox)
			nx = x + dx[3], ny = y + dy[3];
		else if (y > oy)
			nx = x + dx[2], ny = y + dy[2];
		else
			return false;
	}

	ox = x, oy = y;
	x = nx, y = ny;
	return true;
}