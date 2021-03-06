﻿#include<bits/stdc++.h>

#define SIZE 10002

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

	for (int i = 2; i < n; i++) {
		dp[i] = max(dp[i - 2] + board[i], dp[i - 3] + board[i - 1] + board[i]);
		dp[i] = max(dp[i - 1], dp[i]);
	}
	printf("%d", dp[n - 1]);
}