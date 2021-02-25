#include<bits/stdc++.h>

using namespace std;

struct point {
    int x, y;
    int ox, oy;
    int  val;
};

int dx[] = { -1, 0, 1, 0 };
int dy[] = { 0, 1, 0, -1 };

int visited[27][27];

int solution(vector<vector<int>> board) {
    int answer = INT_MAX;
    int size = board.size();
    queue<point> q;

    q.push({ 0, 0, 0, 0, 0 });
    visited[0][0] = 0;

    while (!q.empty()) {
        point tmp = q.front();
        q.pop();

        if (tmp.x == size - 1 && tmp.y == size - 1) {
            answer = min(answer, tmp.val);
            continue;
        }

        for (int i = 0; i < 4; i++) {
            int nx = tmp.x + dx[i];
            int ny = tmp.y + dy[i];
            int nval = tmp.val + 100;

            if (tmp.ox != nx && tmp.oy != ny) {
                nval += 500;
            }

            if (nx < 0 || nx >= size || ny < 0 || ny >= size || board[nx][ny] == 1) {
                continue;
            }

            if (visited[nx][ny] != 0 && visited[nx][ny] < nval) {
                continue;
            }

            q.push({ nx, ny, tmp.x, tmp.y, nval });
            visited[nx][ny] = nval;
        }
    }
    return answer;
}

int main() {
    cout << solution({ {0,0,1, 0}, {0, 0,0,0}, {0,1, 0,1}, {1,0,0,0} });
}