#include<bits/stdc++.h>

#define SIZE 102

using namespace std;

struct robot {
    int dic; //0: 가로, 1:세로
    int ax, ay, bx, by;
};

//상하좌우
int dx[] = { -1,1,0,0 };
int dy[] = { 0,0,-1,1 };
bool visitt[2][SIZE][SIZE];

bool possi(robot robo, int  i, const vector<vector<int>>& board, robot& tmp);

int solution(vector<vector<int>> board) {
    int answer = 0;
    int size = board.size();
    queue<robot> q;

    robot robo;
    robo.dic = 0, robo.ax = 0, robo.ay = 0, robo.bx = 0, robo.by = 1;

    visitt[0][robo.ax][robo.ay] = true;
    q.push(robo);

    while (!q.empty()) {
        int len = q.size();
        while (len--) {
            robot tmp = q.front();
            q.pop();         

            if (tmp.bx == size - 1 && tmp.by == size - 1) {
                return answer;
            }

            robot ntmp;
            for (int i = 0; i < 8; i++) {
                if (!possi(tmp, i, board, ntmp))
                    continue;

                if (visitt[ntmp.dic][ntmp.ax][ntmp.ay] == true)
                    continue;

                visitt[ntmp.dic][ntmp.ax][ntmp.ay] = true;
                q.push(ntmp);
            }
        }
        answer++;
    }
}

bool possi(robot robo, int  i, const vector<vector<int>>& board, robot& tmp) {

    int size = board.size();
    int nax, nay, nbx, nby;
    //이동
    if (i < 4) {
        nax = robo.ax + dx[i];
        nay = robo.ay + dy[i];
        nbx = robo.bx + dx[i];
        nby = robo.by + dy[i];

        //가로
        if (robo.dic == 0) {
            if (nax < 0 || nax >= size || nay < 0 || nby >= size)
                return false;
        }
        //세로
        else {
            if (nax < 0 || nbx >= size || nay < 0 || nay >= size)
                return false;
        }

    }
    //시계방향 a축
    else if (i == 4) {
        
        //가로
        if (robo.dic == 0) {
            nax = robo.ax;
            nay = robo.ay;
            nbx = robo.bx + 1;
            nby = robo.by - 1;
            
            if (nax < 0 || nbx >= size || nay < 0 || nay >= size)
                return false;

            if (board[nax + 1][nay + 1] != 0)
                return false;
        }
        //세로
        else {
            nax = robo.bx -1;
            nay = robo.by -1;
            nbx = robo.ax;
            nby = robo.ay;

            if (nax < 0 || nax >= size || nay < 0 || nby >= size)
                return false;

            if (board[nax + 1][nay] != 0)
                return false;
        }
    }
    //시계 방향 b축
    else if (i == 5) {
        //가로
        if (robo.dic == 0) {
            nax = robo.ax - 1;
            nay = robo.ay + 1;
            nbx = robo.bx;
            nby = robo.by;

            if (nax < 0 || nbx >= size || nay < 0 || nay >= size)
                return false;

            if (board[nax][nay - 1] != 0)
                return false;
        }
        //세로
        else {
            nax = robo.bx;
            nay = robo.by;
            nbx = robo.ax + 1;
            nby = robo.ay + 1;

            if (nax < 0 || nax >= size || nay < 0 || nby >= size)
                return false;

            if (board[nax - 1][nay + 1] != 0)
                return false;
        }
    }
    //반시계방향 a축
    else if (i == 6) {
        //가로
        if (robo.dic == 0) {
            nax = robo.bx - 1;
            nay = robo.by - 1;
            nbx = robo.ax;
            nby = robo.ay;

            if (nax < 0 || nbx >= size || nay < 0 || nay >= size)
                return false;

            if (board[nax][nay + 1] != 0)
                return false;
        }
        //세로
        else {
            nax = robo.ax;
            nay = robo.ay;
            nbx = robo.bx - 1;
            nby = robo.by + 1;

            if (nax < 0 || nax >= size || nay < 0 || nby >= size)
                return false;

            if (board[nax + 1][nay + 1] != 0)
                return false;
        }
    }
    //반시계방향 b축
    else{
    //가로
        if (robo.dic == 0) {
            nax = robo.bx;
            nay = robo.by;
            nbx = robo.ax + 1;
            nby = robo.ay + 1;

            if (nax < 0 || nbx >= size || nay < 0 || nay >= size)
                return false;

            if (board[nax + 1][nay - 1] != 0)
                return false;
        }
        //세로
        else {
            nax = robo.ax + 1;
            nay = robo.ay - 1;
            nbx = robo.bx;
            nby = robo.by;

            if (nax < 0 || nax >= size || nay < 0 || nby >= size)
                return false;

            if (board[nax - 1][nay] != 0)
                return false;
        }
    }

    if (!(board[nax][nay] == 0 && board[nbx][nby] == 0))
        return false;

    if (i >= 4) {
        tmp.dic = (robo.dic == 0 ? 1 : 0);
    }
    else {
        tmp.dic = robo.dic;
    }

    tmp.ax = nax;
    tmp.ay = nay;
    tmp.bx = nbx;
    tmp.by = nby;

    return true;
}

int main() {
    cout << solution({ {0, 0, 0, 0, 0, 0, 0, 0, 0},
{1, 1, 1, 1, 1, 1, 1, 0, 0},
{1, 1, 1, 1, 1, 1, 1, 1, 0},
{0, 0, 0, 0, 0, 0, 0, 0, 0},
{0, 0, 1, 1, 1, 1, 1, 0, 0},
{0, 1, 1, 1, 1, 1, 1, 1, 1},
{0, 0, 1, 1, 1, 1, 1, 0, 0},
{0, 0, 0, 0, 0, 0, 0, 0, 0},
{1, 1, 1, 1, 1, 1, 1, 1, 0} });
}