#include<bits/stdc++.h>

using namespace std;

vector<int> solution(vector<string> gems) {
    vector<int> answer(2);
    set<string> set(gems.begin(), gems.end());
    map<string, int> map;

    map[gems[0]]++;
    int l = 0, r = 0, min = gems.size();
    while (r < gems.size()) {
        if (map.size() == set.size()) {
            if (min > r - l) {
                min = r - l;
                answer[0] = l + 1;
                answer[1] = r + 1;
            }

            if (--map[gems[l]] == 0) {
                map.erase(gems[l]);
            }
            l++;
        }
        else {
            if (r + 1 == gems.size())
                break;
            map[gems[++r]]++;
        }
    }
    return answer;
}