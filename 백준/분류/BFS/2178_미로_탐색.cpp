#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

string maze[100];
int dist[100][100];

int main() {
	int dx[4] = { 1,0,-1,0 };
	int dy[4] = { 0,1,0,-1 };
	int n, m;

	cin >> n >> m;

	for (int i = 0; i < n; i++)
		cin >> maze[i];

	for (int i = 0; i < n; i++)
		fill(dist[i], dist[i] + m, -1);
		// fill(처음, 끝, 값);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (maze[i][j] == '0' || dist[i][j] != -1) continue;
			dist[i][j] = 0;
			queue<pair<int, int>> Q;
			Q.push({ i,j });

			while (!Q.empty()) {
				pair<int, int> cur = Q.front();
				Q.pop();

				for (int dir = 0; dir < 4; dir++) {
					int nx = cur.first + dx[dir];
					int ny = cur.second + dy[dir];

					if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

					if (maze[nx][ny] == '0' || dist[nx][ny] != -1) continue;
					dist[nx][ny] = dist[cur.first][cur.second] + 1;
					Q.push({ nx,ny });
				}
			}
		}
	}
	cout << dist[n - 1][m - 1] + 1;
	// 가장 최단 경로가 가장 먼저 도착하면서 dist를 갱신했을 것이기에
}