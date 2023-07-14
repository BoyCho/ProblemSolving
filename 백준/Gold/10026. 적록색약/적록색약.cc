#include <bits/stdc++.h>
using namespace std;

queue<pair<int, int>> a, b;
bool vis[100][100][2];
string grid[101];
int area_a = 0, area_b = 0, n;

int dx[4] = { 0, -1, 0, 1 };
int dy[4] = { 1, 0, -1, 0 };

int main()
{
	ios::sync_with_stdio(0);
	cin.tie();

	cin >> n;
	for (int i = 0; i < n; i++) cin >> grid[i];
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (!vis[i][j][0]) {
				a.push({ i,j }); vis[i][j][0] = true; area_a++;
			}
			if (!vis[i][j][1]) {
				b.push({ i,j }); vis[i][j][1] = true; area_b++;
			}
			while (!a.empty()) {
				int x = a.front().first;
				int y = a.front().second; 
				a.pop();

				for (int dir = 0; dir < 4; dir++) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];

					if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
					if (vis[nx][ny][0]) continue;
					if ((grid[x][y] == 'R' || grid[x][y] == 'G') && grid[nx][ny] == 'B') continue;
					if (grid[x][y] == 'B' && grid[x][y] != grid[nx][ny]) continue;

					a.push({ nx,ny });
					vis[nx][ny][0] = true;
				}
			}
			while (!b.empty()) {
				int x = b.front().first;
				int y = b.front().second;
				b.pop();

				for (int dir = 0; dir < 4; dir++) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];

					if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
					if (vis[nx][ny][1]) continue;
					if (grid[x][y] != grid[nx][ny]) continue;

					b.push({ nx,ny });
					vis[nx][ny][1] = true;
				}
			}
		}
	}
	cout << area_b << " " << area_a;
}