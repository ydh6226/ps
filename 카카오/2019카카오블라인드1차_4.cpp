#include<bits/stdc++.h>

using namespace std;

int solution(vector<int> food_times, long long k) {
    vector<pair<long long, int>> foods;

    for (int i = 0; i < food_times.size(); i++)
        foods.push_back({ food_times[i], i });
    sort(foods.begin(), foods.end());

    int i;
    for (i = 0; i < foods.size(); i++) {
        long long sum = 0;
        if (i == 0)
            sum = (foods[i].first * foods.size());
        else
            sum = (foods[i].first - foods[i - 1].first) * (foods.size() - i);

        if (k >= sum)
            k -= sum;
        else 
            break;
    }

    if (i == foods.size())
        return -1;

    vector<int> v;
    for (i; i < foods.size(); i++)
        v.push_back(foods[i].second);
    sort(v.begin(), v.end());

    return v[k % v.size()] + 1;
}

int main() {
    cout<<solution({ 4,2,3,6,7,1,5,8 }, 27);
}