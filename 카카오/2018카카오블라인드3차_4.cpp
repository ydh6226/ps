#include<bits/stdc++.h>

using namespace std;

struct music {
    string name;
    int time;
    string melody;
};

void convert(string& s) {
    string ret = "";
    for (char c : s) {
        if (isalpha(c)) {
            ret += c;
            continue;
        }
        int endIndex = ret.length() - 1;
        ret[endIndex] = tolower(ret[endIndex]);
    }
    
    s = ret;
}

string solution(string m, vector<string> musicinfos) {
    vector<music> vm;

    convert(m);

    for (string s : musicinfos) {
        stringstream ss;
        ss.str(s);

        string buf;
        vector<string> v;
        while (getline(ss, buf, ',')) {
            v.push_back(buf);
        }

        int sHour = stoi(v[0].substr(0, 2));
        int sMin = stoi(v[0].substr(3, 2));
        int eHour = stoi(v[1].substr(0, 2));
        int eMin = stoi(v[1].substr(3, 2));

        int min = eMin - sMin;
        if (min < 0) {
            min += 60;
            eHour -= 1;
        }
        int time = (eHour - sHour) * 60 + min;

        string name = v[2];

        convert(v[3]);
        string melody = "";
        for (int i = 0; i < time; i++) {
            melody += v[3][i % v[3].size()];
        }

        music tmp = { name, time, melody };
        vm.push_back(tmp);
    }

    string answer = "(None)";
    int max = -1;

    for (int i = 0; i < vm.size(); i++) {
        string name = vm[i].name;
        int time = vm[i].time;
        string melody = vm[i].melody;

        if (time <= max) {
            continue;
        }

        if (melody.find(m) != string::npos) {
            answer = name;
            max = time;
        }
    }
    return answer;
}


int main() {
    solution("CC#BCC#BCC#BCC#B", { "03:00,03:30,FOO,CC#B", "03:00,03:30,BAR,CC#B" });
}