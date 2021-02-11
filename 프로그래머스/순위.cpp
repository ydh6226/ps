#include<bits/stdc++.h>

#define SIZE 102

bool board[SIZE][SIZE];
int fight[SIZE];


using namespace std;

int solution(int n, vector<vector<int>> results) {
    int answer = 0;

    for (auto vi : results) {
        board[vi[0]][vi[1]] = true;
        fight[vi[0]]++;
        fight[vi[1]]++;
    }


    for (int k = 1; k <= n; k++) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (board[i][j] == false && board[i][k] == true && board[k][j] == true) {
                    board[i][j] = true;
                    fight[i]++;
                    fight[j]++;
                }
            }
        }
    }

    for (int i = 1; i <= n; i++) {
        if (fight[i] == n - 1)
            answer++;
    }
    return answer;
}