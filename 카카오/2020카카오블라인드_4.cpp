#include<bits/stdc++.h>

using namespace std;

bool compare(string a, string b) {
    if (a.length() == b.length()) {
        return a < b;
    }
    return a.length() < b.length();
}

string convert(string str) {
    int idx = str.find('?');
    for (int i = idx; i < str.size(); i++) {
        str[i] = 'z';
    }
    return str;
}

vector<int> solution(vector<string> words, vector<string> queries) {
    vector<int> answer;
    vector<string> reverseWords = words;

    for (auto& word : reverseWords) {
        reverse(word.begin(), word.end());
    }

    sort(words.begin(), words.end(), compare);
    sort(reverseWords.begin(), reverseWords.end(), compare);

    for (auto query : queries) {
        int start, end;

        if (!isalpha(query[0])) {
            reverse(query.begin(), query.end());

            start = lower_bound(reverseWords.begin(), reverseWords.end(), query, compare) - reverseWords.begin();
            end = upper_bound(reverseWords.begin(), reverseWords.end(), convert(query), compare) - reverseWords.begin();
        }
        else {
            start = lower_bound(words.begin(), words.end(), query, compare) - words.begin();
            end = upper_bound(words.begin(), words.end(), convert(query), compare) - words.begin();
        }
        answer.push_back(end - start);
    }
    return answer;
}

int main() {
    vector<string> v = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
    sort(v.begin(), v.end());
    for (auto s : v) {
        cout << s << endl;
    }
    


    solution({ "frodo", "front", "frost", "frozen", "frame", "kakao"}, { "fro??", "????o", "fr???", "fro???", "pro?" });
}