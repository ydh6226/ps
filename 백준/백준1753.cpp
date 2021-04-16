#include<bits/stdc++.h>

#define SIZE 20002
#define INF 6000000

using namespace std;

int d[SIZE];
bool visited[SIZE];
vector<pair<int, int>> vec[SIZE];
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

int main() {
	int v, e, start;
	scanf("%d %d %d", &v, &e, &start);

	for (int i = 0; i < e; i++) {
		int u, v, w;
		scanf("%d %d %d", &u, &v, &w);
		vec[u].push_back({ v, w });
	}

	for (int i = 1; i <= v; i++) {
		d[i] = INF;
	}

	d[start] = 0;
	pq.push({ 0, start });

	while (!pq.empty()) {
		int curDot = pq.top().second;
		int val = pq.top().first;
		pq.pop();

		if (!visited[curDot]) {
			visited[curDot] = true;
			for (int i = 0; i < vec[curDot].size(); i++) {
				int nextDot = vec[curDot][i].first;
				int nextVal = vec[curDot][i].second;

				if (d[nextDot] > val + nextVal) {
					d[nextDot] = val + nextVal;
					pq.push({ d[nextDot], nextDot });
				}
			}
		}
	}

	for (int i = 1; i <= v; i++) {
		if (d[i] == INF) {
			printf("INF\n");
			continue;
		}
		printf("%d\n", d[i]);
	}
}