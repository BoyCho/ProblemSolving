#include <bits/stdc++.h>
using namespace std;

int dis[200][200][31];
int arr[200][200];
int hdx[8] = { -2,-1,1,2,2,1,-1,-2 };
int hdy[8] = { 1,2,2,1,-1,-2,-2,-1 };
int dx[4] = { 0,1,0,-1 };
int dy[4] = { 1,0,-1,0 };

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	int k, w, h;
	cin >> k >> w >> h;

	for (int i = 0; i < h; i++) {
		for (int j = 0; j < w; j++)
			cin >> arr[i][j];
	}

	queue<tuple<int, int, int>> q;
	q.push({ 0,0,k });

	while (!q.empty())
	{
		int x, y, z;
		tie(x, y, z) = q.front(); q.pop();

		if (x == h - 1 && y == w - 1) {
			cout << dis[h - 1][w - 1][z]; return 0;
		}

		for (int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
			if (arr[nx][ny] == 1 || dis[nx][ny][z] != 0) continue;

			q.push({ nx,ny,z });
			dis[nx][ny][z] = dis[x][y][z] + 1;
		}

		if (!z) continue;

		for (int dir = 0; dir < 8; dir++) {
			int nx = x + hdx[dir];
			int ny = y + hdy[dir];

			if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
			if (arr[nx][ny] == 1 || dis[nx][ny][z - 1] != 0) continue;

			q.push({ nx,ny,z - 1 });
			dis[nx][ny][z - 1] = dis[x][y][z] + 1;
		}
	}
	cout << -1;
	return 0;
}