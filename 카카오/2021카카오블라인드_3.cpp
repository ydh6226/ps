#include<bits/stdc++.h>

using namespace std;

vector<int> solution(vector<string> info, vector<string> query) {
    vector<int> answer;
    map<vector<string>, vector<int>> map;
    stringstream ss;


    for (int k = 0; k < info.size(); k++) {
        ss.clear();
        ss.str(info[k]);
        vector<string> sel(4);
        int score;

        for (int i = 0; i < 4; i++)
            ss >> sel[i];
        ss >> score;

        for (int i = 0; i <= 4; i++) {
            vector<int> v(4 - i);
            for (int j = 0; j < i; j++)
                v.push_back(1);

            do {
                vector<string> key;
                for (int j = 0; j < 4; j++) {
                    if (v[j] == 0)
                        key.push_back(sel[j]);
                    else
                        key.push_back("-");
                }
                map[key].push_back(score);
            } while (next_permutation(v.begin(), v.end()));
        }
    }

    for (auto &x : map) {
        sort(x.second.begin(), x.second.end());
    }

    for (int i = 0; i < query.size(); i++) {
        ss.clear();
        ss.str(query[i]);
        vector<string> sel(4);
        int score;

        string buff;
        for (int i = 0; i < 3; i++)
            ss >> sel[i] >> buff;
        ss >> sel[3] >> score;

        vector<int> val = map[sel];

        int l = 0;
        int r = val.size();

        while (l < r) {
            int mid = (l + r) / 2;
            if (val[mid] < score)
                l = mid + 1;
            else
                r = mid;
        }

        answer.push_back(val.size() - r);
    }
    return answer;
}

int main() {
    solution({ "java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50" }, { "java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150" });
}