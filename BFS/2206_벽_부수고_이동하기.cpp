#include <bits/stdc++.h>
using namespace std;

int dis[1000][1000][2];
string s[1000];

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	int dx[4] = { 1, -1, 0, 0 };
	int dy[4] = { 0, 0, 1, -1 };
	int n, m;
	cin >> n >> m;

	for (int i = 0; i < n; i++) cin >> s[i];
	
	queue<tuple<int, int, int>> q;
	q.push({ 0,0,0 });
	dis[0][0][0] = 1;

	while (!q.empty()) {
		int x, y, brk;
		tie(x, y, brk) = q.front(); q.pop();

		if (x == n - 1 && y == m - 1) {
			cout << dis[x][y][brk]; return 0;
		}

		for (int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			int nbrk = brk;

			if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
			if (dis[nx][ny][nbrk] != 0) continue;

			if (s[nx][ny] == '1') {
				if (nbrk) continue;
				dis[nx][ny][nbrk + 1] = dis[x][y][nbrk] + 1;
				nbrk++;
			}
			else dis[nx][ny][nbrk] = dis[x][y][nbrk] + 1;
			
			q.push({ nx,ny,nbrk });
		}
	}
	cout << -1;
}