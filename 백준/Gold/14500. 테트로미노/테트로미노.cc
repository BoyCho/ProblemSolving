#include <bits/stdc++.h>
using namespace std;

int dx[4] = { 0,1,0,-1 };
int dy[4] = { 1,0,-1,0 };
int arr[502][502];
int n, m, cnt, maxv;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> n >> m;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++)
			cin >> arr[i][j];
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			queue<tuple<int, int, int, int, int, int>> q;
			q.push({ i, j, i, j, 1, arr[i][j] });

			while (!q.empty()) 
			{
				int x, y, prevx, prevy, block, sum;
				tie(x, y, prevx, prevy, block, sum) = q.front(); q.pop();

				for (int dir = 0; dir < 4; dir++) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];

					if (nx < 1 || ny < 1 || nx > n || ny > m) continue;
					if (nx == prevx && ny == prevy) continue;

					if (block == 3) {
						maxv = max(maxv, sum + arr[nx][ny]);
						continue;
					}
					q.push({ nx, ny, x, y, block + 1, sum + arr[nx][ny] });
				}
			}

			int sum = arr[i][j] + arr[i][j + 1] + arr[i + 1][j] + arr[i][j - 1] + arr[i - 1][j];
			for (int dir = 0; dir < 4; dir++) {
				int nx = i + dx[dir];
				int ny = j + dy[dir];
				maxv = max(maxv, sum - arr[nx][ny]);
			}
		}
	}
	cout << maxv;
}