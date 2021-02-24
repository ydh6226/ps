#include<bits/stdc++.h>

using namespace std;

int solution(vector<string> words) {
    int answer = 0;

    words.push_back("");
    sort(words.begin(), words.end());
    words.push_back("");

    for (int i = 1; i < words.size() - 1; i++) {
        int j, size;
        int count1 = 0, count2 = 0;

        string before = words[i - 1];
        string cur = words[i];
        string next = words[i + 1];

        size = min(before.size(), cur.size());
        for (j = 0; j < size; j++) {
            if (before[j] != cur[j]) {
                break;
            }
            count1++;
        }
        if (j != cur.size()) {
            count1++;
        }

        size = min(cur.size(), next.size());
        for (j = 0; j < size; j++) {
            if (cur[j] != next[j]) {
                break;
            }
            count2++;
        }
        if (j != cur.size()) {
            count2++;
        }

        answer += std::max(count1, count2);
    }
    return answer;
}

int main() {
    solution({ "word", "war", "warrior", "world" });
}