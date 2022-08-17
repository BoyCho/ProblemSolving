#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>
#include <map>
using namespace std;


struct cmp {
    bool operator()(pair<double, int> a, pair<double, int> b) {
        if (a.first == b.first) {
            return a.second > b.second;
        }
        return a.first < b.first;
    }
};
priority_queue<pair<double, int>, vector<pair<double, int>>, cmp> pq;
map<int, int> m;

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    double size = stages.size();

    for (int i = 0; i < size; i++) {
        m[stages[i]]++;
    }
    for (int i = 1; i <= N; i++) {
        double tmp = m[i];
        if (size == 0 && tmp == 0) {
            pq.push({ 0,i });
            continue;
        }
        pq.push({ tmp / size, i });
        size -= m[i];
    }
    while (!pq.empty()) {
        auto cur = pq.top(); pq.pop();
        answer.push_back(cur.second);
    }
    return answer;
}