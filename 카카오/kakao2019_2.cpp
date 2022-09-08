#include <iostream>
#include <sstream>
#include <cstring>
#include <vector>
#include <map>

using namespace std;

vector<string> solution(vector<string> record) {

    vector<pair<bool, string>> ch;
    map<string, string> name;
    vector<string> answer;

    for (int i = 0; i < record.size(); i++) {
        stringstream  ss(record[i]);
        vector<string> tmp;
        string s;

        while (getline(ss, s, ' ')) tmp.push_back(s);

        if (strcmp(tmp[0].c_str(), "Enter") == 0) {
            ch.push_back({ true, tmp[1] });
            name[tmp[1]] = tmp[2];
        }
        if (strcmp(tmp[0].c_str(), "Leave") == 0)
            ch.push_back({ false, tmp[1] });
        else
            name[tmp[1]] = tmp[2];
    }

    for (int i = 0; i < ch.size(); i++) {
        if (ch[i].first)
            answer.push_back(name[ch[i].second] + "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.");
        else
            answer.push_back(name[ch[i].second] + "´ÔÀÌ ³ª°¬½À´Ï´Ù.");
    }


    return answer;
}