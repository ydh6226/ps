#include<bits/stdc++.h>

#define SIZE 52
#define INF 6000000

using namespace std;

int d[SIZE];
bool visited[SIZE];
vector<pair<int, int>> graph[SIZE];
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

int solution(int N, vector<vector<int> > road, int K) {
    int answer = 0;

    for (int i = 1; i <= N; i++) {
        d[i] = INF;
    }

    for (auto vi : road) {
        int from = vi[0];
        int to = vi[1];
        int w = vi[2];

        graph[from].push_back({ to, w });
        graph[to].push_back({ from, w });
    }

    pq.push({ 0, 1 });
    d[1] = 0;

    while (!pq.empty()) {
        int curDot = pq.top().second;
        int val = pq.top().first;
        pq.pop();

        if (!visited[curDot]) {
            visited[curDot] = true;

            for (int i = 0; i < graph[curDot].size(); i++) {
                int nextDot = graph[curDot][i].first;
                int nextval = graph[curDot][i].second;

                if (d[nextDot] > val + nextval) {
                    d[nextDot] = val + nextval;
                    pq.push({ d[nextDot], nextDot });
                }
            }
        }
    }

    for (int i = 1; i <= N; i++) {
        if (d[i] <= K)
            answer++;
    }
    return answer;
}