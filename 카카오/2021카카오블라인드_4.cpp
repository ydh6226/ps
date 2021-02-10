#include<bits/stdc++.h>

#define SIZE 202
#define NON 0x3f3f3f3f

using namespace std;

int board[SIZE][SIZE];

int solution(int n, int s, int a, int b, vector<vector<int>> fares) {
    int answer = NON;

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (i == j)
                board[i][j] = 0;
            else
                board[i][j] = NON;
        }
    }

    for (auto vi : fares) {
        board[vi[0]][vi[1]] = vi[2];
        board[vi[1]][vi[0]] = vi[2];
    }

    for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = min(board[i][j], board[i][k] + board[k][j]);
            }
        }
    }

    for (int k = 1; k <= n; k++) {
        answer = min<long long>(answer, (long long)board[s][k] + board[k][a] + board[k][b]);
    }
    return answer;
}