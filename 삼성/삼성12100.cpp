#include<bits/stdc++.h>

using namespace std;

int answer;
int n;

void rotate(vector<vector<int>>& board) {
	vector<vector<int>> temp(n, vector<int>(n));

	for (int i = 0; i < n; i++) {
		for (int j = n - 1; j >= 0; j--) {
			temp[i][n - j - 1] = board[j][i];
		}
	}
	
	board = temp;
}

vector<vector<int>> up(vector<vector<int>> board) {
	for (int i = 0; i < n; i++) {
		vector<int> v;
		bool used = false;

		for (int j = 0; j < n; j++) {
			if (board[j][i] == 0)
				continue;

			if (v.size() == 0)
				v.push_back(board[j][i]);
			else {
				if (used == false && v.back() == board[j][i]) {
					v.back() *= 2;
					used = true;
				}
				else {
					v.push_back(board[j][i]);
					used = false;
				}
			}
		}

		for (int j = 0; j < v.size(); j++) {
			board[j][i] = v[j];
		}
		for (int j = v.size(); j < n; j++) {
			board[j][i] = 0;
		}
	}

	cout << endl;
	return board;
}

void dfs(vector<vector<int>> board, int count) {
	if (count == 5) {
		int m = 0;
		for (int i = 0; i < n; i++) {
			m = max(m, *max_element(board[i].begin(), board[i].end()));
		}
		
		answer = max(answer, m);
		return;
	}


	for (int i = 0; i < 4; i++) {
		dfs(up(board), count + 1);
		rotate(board);
	}
}


int main() {
	scanf("%d", &n);
	vector<vector<int>> board(n, vector<int>(n));

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			int x;
			scanf("%d", &x);
			board[i][j] = x;
		}
	}
	dfs(board, 0);
	cout << answer << endl;
}