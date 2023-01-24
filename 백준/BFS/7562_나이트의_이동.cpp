#include <bits/stdc++.h>
using namespace std;

int dx[8] = { -2,-1,1,2,2,1,-1,-2 };
int dy[8] = { 1,2,2,1,-1,-2,-2,-1 };
queue<pair<int, int>> q;
int dis[301][301];

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	int n;

	cin >> n;
	while (n--) {
		int l;
		cin >> l;

		int x, y;
		cin >> x >> y;

		memset(dis, -1, sizeof(dis));

		q.push({ x, y });
		dis[x][y] = 0;

		cin >> x >> y;
		while (dis[x][y] == -1 && !q.empty()) {
			int x_, y_;
			tie(x_, y_) = q.front(); q.pop();

			for (int dir = 0; dir < 8; dir++) {
				int nx = x_ + dx[dir];
				int ny = y_ + dy[dir];

				if (nx < 0 || ny < 0 || nx >= l || ny >= l) continue;
				if (dis[nx][ny] != -1) continue;

				q.push({ nx,ny });
				dis[nx][ny] = dis[x_][y_] + 1;
			}
		}
		cout << dis[x][y] << "\n";
	}
}