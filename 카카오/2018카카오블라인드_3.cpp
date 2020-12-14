#include<bits/stdc++.h>

using namespace std;

int solution(string str1, string str2) {
    int inter = 0, uni = 0;
    map<string, int> a;
    map<string, int> b;

    transform(str1.begin(), str1.end(), str1.begin(), ::tolower);
    transform(str2.begin(), str2.end(), str2.begin(), ::tolower);

    for (int i = 0; i < str1.size() - 1; i++)
        if (isalpha(str1[i]) && isalpha(str1[i + 1])) {
            a[str1.substr(i,2)]++;
        }

    for (int i = 0; i < str2.size() - 1; i++)
        if (isalpha(str2[i]) && isalpha(str2[i + 1])) {
            b[str2.substr(i, 2)]++;
            a[str2.substr(i, 2)];
        }

    //auto 대신 pair<string, int> 사용 가능.
    for (auto x : a) {
        int num1 = x.second;
        int num2 = b[x.first];

        inter += min(num1, num2);
        uni += max(num1, num2);
    }

    if (uni == 0)
        return 65536;

    return int((float)inter / uni * 65536);
}

int main() {
    string str1 = "FRANCE";
    string str2 = "french";
    cout << solution(str1, str2);
}