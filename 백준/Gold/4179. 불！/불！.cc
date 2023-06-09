#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

string maze[1002];
int dist[1002][1002];

int main()
{
	queue<pair<int, int>> FQ;
	queue<pair<int, int>> JQ;
	int dx[4] = { 1,0,-1,0 };
	int dy[4] = { 0,1,0,-1 };
	int r, c;

	cin >> r >> c;

	for (int i = 0; i < r; i++)
		cin >> maze[i];
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			if (maze[i][j] == 'F')
				FQ.push({ i,j });
			else if (maze[i][j] == 'J')
				JQ.push({ i,j });
			else if (maze[i][j] == '.')
				dist[i][j] = -1;
		}
	}

	while (!FQ.empty()) {
		pair<int, int> cur = FQ.front();
		FQ.pop();

		for (int dir = 0; dir < 4; dir++) {
			int nx = cur.first + dx[dir];
			int ny = cur.second + dy[dir];

			if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
			if (maze[nx][ny] == '#' || dist[nx][ny] != -1) continue;

			dist[nx][ny] = dist[cur.first][cur.second] + 1;
			FQ.push({ nx,ny });
		}
	}

	while (!JQ.empty()) {
		pair<int, int> cur = JQ.front();
		JQ.pop();

		for (int dir = 0; dir < 4; dir++) {
			int nx = cur.first + dx[dir];
			int ny = cur.second + dy[dir];

			if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
				cout << dist[cur.first][cur.second] + 1;
				return 0;
			}

			if (maze[nx][ny] != '.') continue;
			if (dist[nx][ny] != -1 && dist[cur.first][cur.second] + 1 >= dist[nx][ny]) continue;

			dist[nx][ny] = dist[cur.first][cur.second] + 1;
			maze[nx][ny] = 'J';
			JQ.push({ nx,ny });
		}
	}
	cout << "IMPOSSIBLE";
}