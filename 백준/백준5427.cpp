#include<bits/stdc++.h>

using namespace std;

#define SIZE 1002

struct point {
    int x, y;
};

int w, h;
int dx[] = { -1,0,1,0 };
int dy[] = { 0,1,0,-1 };
char board[SIZE][SIZE];


void fire(queue<point>& fireQ) {
    int len = fireQ.size();
    while (len--) {
        point tmp = fireQ.front();
        fireQ.pop();

        for (int i = 0; i < 4; i++) {
            int nx = tmp.x + dx[i];
            int ny = tmp.y + dy[i];

            if (nx < 0 || nx >= h || ny < 0 || ny >= w || board[nx][ny] == '#' || board[nx][ny] == '*')
                continue;

            board[nx][ny] = '*';

            point ntmp;
            ntmp.x = nx, ntmp.y = ny;
            fireQ.push(ntmp);
        }
    }

    /*
    for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
            cout << board[i][j] << " ";
        }
        cout << endl;
    }
    cout << "";
    */
}



int main() {
    int n;
    scanf("%d", &n);

    point p;
    for (int i = 0; i < n; i++) {
        queue<point> fireQ;

        scanf("%d %d", &w, &h);
        for (int j = 0; j < h; j++) {
            scanf("%s", &board[j]);
            for (int k = 0; k < w; k++) {
                if (board[j][k] == '@') {
                    board[j][k] = '.';
                    p.x = j, p.y = k;
                }
                else if (board[j][k] == '*') {
                    point tmp;
                    tmp.x = j, tmp.y = k;
                    fireQ.push(tmp);
                }
            }
        }

        bool visit[SIZE][SIZE] = { 0 };

        queue<point> q;

        q.push(p);
        visit[p.x][p.y] = true;

        
        int count = 0;
        bool flag = false;
        while (!q.empty()) {
            int len = q.size();
            fire(fireQ);
            while (len--) {
                point tmp = q.front();
                q.pop();

                if (tmp.x == 0 || tmp.x == h - 1 || tmp.y == 0 || tmp.y == w - 1) {
                    printf("%d\n", count + 1);
                    flag = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = tmp.x + dx[i];
                    int ny = tmp.y + dy[i];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w || board[nx][ny] == '#' || board[nx][ny] == '*')
                        continue;

                    if (visit[nx][ny] == true) {
                        continue;
                    }

                    point ntmp;
                    ntmp.x = nx;
                    ntmp.y = ny;

                    q.push(ntmp);
                    visit[ntmp.x][ntmp.y] = true;

                }


            }
            if (flag == true)
                break;
            count++;
            
        }
        if(flag == false)
            printf("IMPOSSIBLE\n");
    }
}