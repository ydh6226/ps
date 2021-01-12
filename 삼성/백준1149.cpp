#include<bits/stdc++.h>

using namespace std;

#define SIZE 1002
#define COLOR 3

int n;
int board[SIZE][COLOR];
int dp[SIZE][COLOR];

int main() {
	int answer;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 3; j++) {
			scanf("%d", &board[i][j]);
		}
	}

	dp[0][0] = board[0][0];
	dp[0][1] = board[0][1];
	dp[0][2] = board[0][2];

	for (int i = 1; i < n; i++) {
		dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + board[i][0];
		dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + board[i][1];
		dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + board[i][2];
	}

	answer = min({ dp[n - 1][0], dp[n - 1][1] , dp[n - 1][2] });
	printf("%d", answer);
}