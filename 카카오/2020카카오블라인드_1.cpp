#include<bits/stdc++.h>

using namespace std;

int solution(string s) {
    int size = s.size();
    int answer = size;

    for (int i = 1; i <= size/2; i++) {
        string prev = s.substr(0, i);
        int count = 1;
        int len = 0;

        int index = i;
        while (index < size) {
            string cur = s.substr(index, i);

            if (prev == cur) {
                count++;
            }
            else {
                len += i;
                if (count != 1)
                    len += to_string(count).size();

                prev = cur;
                count = 1;
            }
            index += i;
        }
        if (count == 1)
            len += prev.size();
        else
            len += i + to_string(count).size();
        answer = min(answer, len);
    }
    return answer;
}