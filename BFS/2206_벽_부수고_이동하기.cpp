#include <algorithm>
#include <iostream>
#include <tuple>
#include <queue>
using namespace std;

vector<string> map;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	int dx[4] = { 0,-1,0,1 };
	int dy[4] = { 1,0,-1,0 };
	int n, m, ans = 0;
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		string tmp;
		cin >> tmp; map.push_back(tmp);
	}

	queue<tuple<int, int, int>> q;
	q.push({ 0,0,1 });

	while (!q.empty()) {
		int x, y, dis;
		tie(x, y, dis) = q.front(); q.pop();

		if (x == n - 1 && y == m - 1) {
			if (dis > 0) cout << dis;
			else cout << dis * -1;
			return 0;
		}

		for (int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
			if (map[nx][ny] == '1') {
				if (dis > 0) dis *= -1;
				else continue;
			}
			if (dis < 0) q.push({ nx,ny, dis - 1 });
			else q.push({ nx,ny, dis + 1 });
		}
	}
	cout << -1;
}