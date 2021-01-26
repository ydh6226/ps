#include<bits/stdc++.h>

using namespace std;

string solution(string new_id) {
    string answer = "";

    transform(new_id.begin(), new_id.end(), new_id.begin(), ::tolower);

    string tmp = "";
    int count = 0;

    for (int i = 0; i < new_id.size(); i++) {
        char c = new_id[i];
        if (isdigit(c) || islower(c) || isupper(c) || c == '-' || c == '_' || c == '.') {
            if (c == '.')
                count++;
            else
                count = 0;

            if (count < 2)
                tmp += c;
        }
    }

    if (tmp.front() == '.')
        tmp.erase(0, 1);

    if (tmp.back() == '.')
        tmp.erase(tmp.size() - 1, 1);

    if (tmp.empty())
        tmp += 'a';

    if (tmp.size() >= 16)
        tmp = tmp.substr(0, 15);

    if (tmp.back() == '.')
        tmp.erase(tmp.size() - 1, 1);

    while (tmp.size() <= 2) {
        tmp += tmp.back();
    }

    return tmp;
}