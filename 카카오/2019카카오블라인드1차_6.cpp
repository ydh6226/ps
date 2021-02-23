#include<bits/stdc++.h>

using namespace std;

int solution(string word, vector<string> pages) {
    vector<string> keys;
    map<string, pair<int, int>> map;
    vector<vector<string>> links;

    transform(word.begin(), word.end(), word.begin(), ::tolower);
    for (int i = 0; i < pages.size(); i++) {
        string& page = pages[i];

        transform(page.begin(), page.end(), page.begin(), ::tolower);

        bool flag = false;
        int count = 0;
        string url;
        vector<string> link;


        string urlPattern = "<meta property=\"og:url\" content=\"https://";
        int urlStartIndex = page.find(urlPattern) + urlPattern.length();
        int urlEndIndex = page.find("\"", urlStartIndex);

        url = page.substr(urlStartIndex, urlEndIndex - urlStartIndex);

        string body = page.substr(page.find("<body>"));


        string hrefPattern = "<a href=\"https://";
        int hrefStartIndex = 0;
        int hrefEndIndex = -1;


        while (true) {
            hrefStartIndex = body.find(hrefPattern, hrefStartIndex);
            if (hrefStartIndex == -1)
                break;
            hrefStartIndex += hrefPattern.length();
            hrefEndIndex = body.find("\">", hrefStartIndex);

            link.push_back(body.substr(hrefStartIndex, hrefEndIndex - hrefStartIndex));
        }

        string tmp = "";
        for (char c : page) {
            if (isalpha(c)) {
                tmp += c;
                continue;
            }

            if (tmp == word) {
                count++;
            }
            tmp = "";
        }

        keys.push_back(url);
        map[url] = { count, link.size() };
        links.push_back(link);
    }

    std::map<string, double> scoreMap;

    for (int i = 0; i < links.size(); i++) {
        string url = keys[i];

        if (map[url].second == 0)
            continue;

        double score = (double)map[url].first / map[url].second;

        for (int j = 0; j < links[i].size(); j++) {
            scoreMap[links[i][j]] += score;
        }
    }

    double max = -1;
    int answer = 0;

    for (int i = 0; i < keys.size(); i++) {
        string url = keys[i];
        double score = map[url].first + scoreMap[url];

        if (score > max) {
            answer = i;
            max = score;
        }
    }
    return answer;
}


int main() {
    cout<<solution("blind", {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"});

}


