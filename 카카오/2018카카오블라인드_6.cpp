#include<bits/stdc++.h>

using namespace std;

int solution(int m, int n, vector<string> board) {
    int answer = 0;
    vector<string> b(n);

    for (int i = 0; i < n; i++)
        for (int j = m - 1; j >= 0; j--)
            b[i].push_back(board[j][i]);

    while (true) {
        vector<set<int>> forErase(n);
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                char x = b[i][j];
                char y = b[i][j + 1];
                char z = b[i + 1][j];
                char w = b[i + 1][j + 1];

                if (x != '0' && x == y && y == z && z == w) {
                    forErase[i].insert(j);
                    forErase[i].insert(j + 1);
                    forErase[i + 1].insert(j);
                    forErase[i + 1].insert(j + 1);
                    count++;
                }
            }
        }
        if (count == 0)
            break;

        for (int i = 0; i < n; i++) {
            int error = 0;
            for (int j : forErase[i]) {
                b[i].erase(j - error, 1);
                b[i] += "0";
                error++;
                answer++;
            }
        }
    }
    return answer;
}

int main() {
    cout << solution(6, 6, { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ" });
}