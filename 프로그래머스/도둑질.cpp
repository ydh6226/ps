#include<bits/stdc++.h>

using namespace std;

int dp[1000002];

int solution(vector<int> money) {
    int answer = 0;
    int size = money.size();

    //첫번째 집 터는 경우
    dp[0] = money[0];
    dp[1] = money[0];

    for (int i = 2; i < size - 1; i++) {
        dp[i] = max(dp[i - 2] + money[i], dp[i - 1]);
    }

    answer = dp[size - 2];

    //첫번째 집 안터는 경우 -> 두번째, 마지막 집은 털수도 안털수도 있음.
    dp[0] = 0;
    dp[1] = money[1];
    for (int i = 2; i < size; i++) {
        dp[i] = max(dp[i - 2] + money[i], dp[i - 1]);
    }

    answer = max(answer, dp[size - 1]);

    return answer;
}