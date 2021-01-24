#include<bits/stdc++.h>

using namespace std;

bool check(string p) {
    int count = 0;

    for (int i = 0; i < p.size(); i++) {
        p[i] == '(' ? count++ : count--;
        if (count < 0)
            return false;
    }
    return true;
}

string solution(string p) {
    if (p == "")
        return "";
    if (check(p) == true)
        return p;

    int i, count = 0;
    for (i = 0; i < p.size(); i++) {
        p[i] == '(' ? count++ : count--;
        if (count == 0)
            break;
    }

    string u = p.substr(0, i + 1);
    string v = p.substr(i + 1);

    if (check(u) == true) {
        return u + solution(v);
    }
    else {
        string tmp = "(" + solution(v) + ")";
        u = u.substr(1, u.size() - 2);
        
        for (int i = 0; i < u.size(); i++)
            u[i] = u[i] == '(' ? ')' : '(';

        tmp += u;
        return tmp;
    }
}



int main() {
    cout << solution("()))((()");
}