#include<bits/stdc++.h>
#include<unordered_map>

using namespace std;
using ll = long long;

unordered_map<ll, ll> uMap;

ll getRoom(ll num) {
    if (uMap[num] == 0) {
        uMap[num] = num + 1;
        return num;
    }
    return uMap[num] = getRoom(uMap[num]);
}

vector<ll> solution(ll k, vector<ll> room_number) {
    vector<ll> answer;
    for (ll num : room_number) {
        answer.push_back(getRoom(num));
    }
    return answer;
}
