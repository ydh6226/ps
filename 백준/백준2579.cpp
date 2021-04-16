#include<bits/stdc++.h>

#define SIZE 302

using namespace std;

int n;
int board[SIZE];
int dp[SIZE];


int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &board[i]);
	}

	dp[0] = board[0];
	dp[1] = board[0] + board[1];
	dp[2] = max(board[0] + board[2], board[1] + board[2]);

	for (int i = 3; i < n; i++) {
		dp[i] = max(dp[i - 3] + board[i - 1] + board[i], dp[i - 2] + board[i]);
	}
	printf("%d", dp[n - 1]);
}