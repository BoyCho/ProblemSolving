#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>
#include <tuple>
#include <map>

using namespace std;

#define X first
#define Y second

map<pair<int, int>, int> node;
map<pair<int, int>, int> d;

const int INF = 125 * 125 * 9 + 1;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	priority_queue<tuple<int,int, int>, vector<tuple<int,int, int>>, greater<tuple<int,int,int>>> pq;
	vector<int> ans;

	int dx[4] = { 1,0,-1,0 };
	int dy[4] = { 0,1,0,-1 };
	int n;
	while (true) {
		cin >> n;
		if (!n) break;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cin >> node[{i, j}];
				d[{i, j}] = INF;
			}
		}
		d[{0, 0}] = node[{0, 0}];
		pq.push({ d[{0,0}],0,0 });

		while (!pq.empty()) {
			int curX = get<1>(pq.top());
			int curY = get<2>(pq.top());
			int curD = get<0>(pq.top());
			pq.pop();

			if (d[{curX, curY}] != curD) continue;

			for (int dir = 0; dir < 4; dir++) {
				int nxtX = curX + dx[dir], nxtY = curY + dy[dir];

				if (nxtX < 0 || nxtY < 0 || nxtX >= n || nxtY >= n) continue;
				if (d[{nxtX, nxtY}] <= curD + node[{nxtX, nxtY}]) continue;

				d[{nxtX, nxtY}] = curD + node[{nxtX, nxtY}];
				pq.push({ d[{nxtX, nxtY}], nxtX,nxtY });
			}

		}
		ans.push_back(d[{n - 1, n - 1}]);
	}
	for (int i = 0; i < ans.size(); i++)
		cout << "Problem " << i + 1 << ": " << ans[i] << "\n";
}