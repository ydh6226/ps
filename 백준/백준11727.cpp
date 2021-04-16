#include<bits/stdc++.h>

#define SIZE 1002

int n;
int dp[SIZE];

int main() {
	scanf("%d", &n);

	dp[0] = 1;
	dp[1] = 3;

	for (int i = 2; i < n; i++) {
		dp[i] = ( dp[i-2]*2 + dp[i-1]) % 10007;
	}
	printf("%d", dp[n - 1]);
}