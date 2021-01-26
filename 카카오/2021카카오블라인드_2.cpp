#include<bits/stdc++.h>

using namespace std;

bool compare(pair<string, int> a, pair<string, int> b) {
	return a.second < b.second;
}

vector<string> comb(string order, int size) {
	vector<string> ret;
	vector<int> v(order.size(), 0);

	sort(order.begin(), order.end());

	for (int i = 0; i < size; i++) {
		v[i] = 1;
	}

	do {
		string str = "";

		for (int i = 0; i < order.size(); i++) {
			if (v[i] == 1)
				str += order[i];
		}
		ret.push_back(str);
	} while (prev_permutation(v.begin(), v.end()));

	return ret;
}

vector<string> solution(vector<string> orders, vector<int> course) {
	vector<string> answer;

	for (int size : course) {
		map<string, int> map;

		for (string order : orders) {
			if (order.size() < size)
				continue;

			for (string key : comb(order, size)) {
				map[key]++;
			}
		}

		int max = (*max_element(map.begin(), map.end(), compare)).second;
		if (max < 2)
			max = 2;

		for (pair<string, int> p : map) {
			if (p.second == max)
				answer.push_back(p.first);
		}
	}
	sort(answer.begin(), answer.end());
	return answer;
}

int main() {
	vector<int> v(7);

	cout << v[4];
}