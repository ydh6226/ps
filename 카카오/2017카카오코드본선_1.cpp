#include<bits/stdc++.h>

using namespace std;

int solution(int n, vector<string> data) {
    int answer = 0;
    string line = "ACFJMNRT";
    vector<string> lines;

    do{
        bool possible = true;
        for (int i = 0; i < n; i++) {
            char a = data[i][0];
            char b = data[i][2];
            char op = data[i][3];
            int distance = int(data[i][4] - '0');

            int d = line.find(a) - line.find(b);
            int real_distance = abs(d) - 1;

            if (op == '=' && real_distance != distance) {
                possible = false;
                break;
            }
            else if(op == '<' && real_distance >= distance) {
                possible = false;
                break;
            }
            else if(op == '>' && real_distance <= distance){
                possible = false;
                break;
            }
        }

        if (possible)
            answer++;

    } while (next_permutation(line.begin(), line.end()));
    return answer;
}

int main() {
    int n = 2;
    vector<string> data = { "M~C<2", "C~M>1" };

    cout << solution(n, data);    
}