#include<bits/stdc++.h>

using namespace std;

using ll = long long;
int board[10002];

int main() {
	int n, m, answer = 0;
	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++) {
		scanf("%d", &board[i]);
	}

	int l = 0, r = 0;
	int sum = board[l];
	while (l<n && r<n) {
		if (sum == m)
			answer++;

		if (sum < m)
			sum += board[++r];
		else
			sum -= board[l++];
	}
	printf("%d", answer);
}