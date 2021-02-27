#include<bits/stdc++.h>

using namespace std;

string solution(int n, int t, int m, vector<string> timetable) {
    vector<int> busVec;
    vector<int> timeVec;

    for (auto time : timetable) {
        stringstream ss;
        ss.str(time);

        string h, m;
        getline(ss, h, ':');
        getline(ss, m, ':');

        int t = stoi(h) * 60 + stoi(m);
        timeVec.push_back(stoi(h) * 60 + stoi(m));
    }
    sort(timeVec.begin(), timeVec.end());

    for (int i = 0; i < n; i++) {
        busVec.push_back(540 + i * t);
    }

    int idx = 0;
    vector<int> lastbus;
    for (int i = 0; i < n; i++) {
        int cur = 0;
        while (idx < timeVec.size() && cur < m && busVec[i] >= timeVec[idx]) {
            if (i == n - 1) {
                lastbus.push_back(timeVec[idx]);
            }

            cur++;
            idx++;
        }
    }

    int answer;
    if (lastbus.size() < m) {
        answer = busVec.back();
    }
    else {
        answer = *(unique(lastbus.begin(), lastbus.end()) - 1) - 1;
    }

    string hstr = to_string(answer / 60);
    string mstr = to_string(answer % 60);

    if (hstr.length() == 1) {
        hstr = "0" + hstr;
    }

    if (mstr.length() == 1) {
        mstr = "0" + mstr;
    }

    return hstr + ":" + mstr;
}

int main() {
    solution(2, 1, 2, { "09:00" });
}