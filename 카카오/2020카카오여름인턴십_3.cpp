#include<bits/stdc++.h>

using namespace std;

vector<int> solution(vector<string> gems) {
    vector<int> answer = { 0,0 };
    set<string>  set(gems.begin(), gems.end());
    map<string, int> map;
    int left = 0, right = 0, min_len= gems.size();

    while (left <= right && left < gems.size()) {
        if (map.size() == set.size()) {
            if (min_len > right - left - 1) {
                min_len = right - left - 1;
                answer[0] = left + 1;
                answer[1] = right;
            }

            map[gems[left]] -= 1;
            if (map[gems[left]] == 0)
                map.erase(gems[left]);
            left++;
        }
        else if (right == gems.size())
            break;
        else {
            map[gems[right++]] += 1;
        }
    }
    return answer;
}

int main() {
    vector<int> v = solution({ "A" , "A", "B"});
    cout << v[0] << ", " << v[1];
}