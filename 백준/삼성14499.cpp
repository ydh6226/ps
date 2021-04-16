#include<bits/stdc++.h>

using namespace std;

void rotation(vector<int>& dice, int dire) {
	vector<int> temp = dice;

	if (dire == 1) {
		temp[0] = dice[4];
		temp[2] = dice[5];
		temp[4] = dice[2];
		temp[5] = dice[0];
	}
	else if (dire == 2) {
		temp[0] = dice[5];
		temp[2] = dice[4];
		temp[4] = dice[0];
		temp[5] = dice[2];
	}
	else if (dire == 3) {
		temp[0] = dice[3];
		temp[1] = dice[0];
		temp[2] = dice[1];
		temp[3] = dice[2];
	}
	else {
		temp[0] = dice[1];
		temp[1] = dice[2];
		temp[2] = dice[3];
		temp[3] = dice[0];
	}
	dice = temp;
}

int main() {
	int n, m, x, y, k;
	scanf("%d %d %d %d %d", &n, &m, &x, &y, &k);
	vector<vector<int>> map(n, vector<int>(m));
	vector<int> go;
	vector<int> dice(6, 0);
	int dx[4] = {0,0,-1,1};
	int dy[4] = {1,-1,0,0};

	int temp;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%d", &temp);
			map[i][j] = temp;
		}
	}

	for (int i = 0; i < k; i++) {
		scanf("%d", &temp);
		go.push_back(temp);
	}

	int nx, ny;
	for (int i = 0; i < k; i++) {
		temp = go[i];
		nx = x + dx[temp - 1];
		ny = y + dy[temp - 1];

		if (!(nx >= 0 && nx < n && ny >= 0 && ny < m))
			continue;
		x = nx;
		y = ny;

		rotation(dice, temp);
		if (map[x][y] != 0) {
			dice[2] = map[x][y];
			map[x][y] = 0;
		}
		else {
			map[x][y] = dice[2];
		}
		printf("%d\n", dice[0]);
	}
}