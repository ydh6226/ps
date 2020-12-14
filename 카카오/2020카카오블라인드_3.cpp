#include<bits/stdc++.h>

using namespace std;

void rotation(vector<vector<int>>& key) {
    int size = key.size();
    vector<vector<int>> temp(size);

    for (int i = 0; i < size; i++)
        for (int j = size - 1; j >= 0; j--)
            temp[i].push_back(key[j][i]);

    key = temp;
}

bool solution(vector<vector<int>> key, vector<vector<int>> lock) {
    int bigSize = lock.size() + key.size() * 2;
    vector<vector<int>> paddingLock(bigSize, vector<int>(bigSize, 0));

    for (int i = key.size(); i < key.size() + lock.size(); i++)
        for (int j = key.size(); j < key.size() + lock.size(); j++)
            paddingLock[i][j] = lock[i - key.size()][j - key.size()];

    for (int i = 0; i < 4; i++) {
        rotation(key);

        for (int i = 0; i < key.size() + lock.size(); i++) {
            for (int j = 0; j < key.size() + lock.size(); j++) {
                vector<vector<int>> paddingKey(bigSize, vector<int>(bigSize, 0));

                for (int a = 0; a < key.size(); a++)
                    for (int b = 0; b < key.size(); b++)
                        paddingKey[a + i][b + j] = key[a][b];

                int count = 0;
                for (int a = 0; a < lock.size(); a++) {
                    for (int b = 0; b < lock.size(); b++) {
                        int padding = key.size();

                        if (lock[a][b] == 1 && paddingKey[a + padding][b + padding] == 0)
                            count++;
                        else if(lock[a][b] == 0 && paddingKey[a + padding][b + padding] == 1)
                            count++;
                    }
                }

                if (count == lock.size() * lock.size())
                    return true;
            }
        }
    }
    return false;
}

int main() {
    vector<vector<int>> key = { {0,0,0 }, {1,0,0}, { 0,1,1}};
    cout<<solution(key, { {1,1,1}, {1,1,0}, {1,0,1} });

}
