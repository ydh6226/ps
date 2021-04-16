#include<bits/stdc++.h>

using namespace std;

using ll = long long;
int board[100002];

int main() {
	int n, m, answer = INT_MAX;
	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++)
		scanf("%d", &board[i]);

	int l = 0, r = 0;
	int sum = board[l];
	while (l<n && r<n) {
		if (sum < m)
			sum += board[++r];
		else {
			int len = r - l + 1;
			answer = min(answer, len);

			sum -= board[l++];
		}
	}
	if(answer == INT_MAX)
		printf("0");
	else
		printf("%d", answer);
}