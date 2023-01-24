#include <iostream>
#include <algorithm>
#include <queue>

int board[1002][1002];
int dist[1002][1002];
// �������� ������ ���� �迭�� �ʱⰪ�� �׻� 0

using namespace std;

int main()
{
	queue<pair<int, int>> Q;
	int dx[4] = { 1,0,-1,0 };
	int dy[4] = { 0,1,0,-1 };
	int n, m;

	cin >> m >> n;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> board[i][j];
			if (board[i][j] == 1)
				Q.push({ i,j });
			else if (board[i][j] == 0)
				dist[i][j] = -1;
		}
	}

	pair<int, int> cur;
	while (!Q.empty()) {
		cur = Q.front();
		Q.pop();

		// �湮 ǥ��, �Ÿ� ǥ�ô� �׻� push �ϸ鼭 �Ѵ�

		for (int dir = 0; dir < 4; dir++) {
			int nx = cur.first + dx[dir];
			int ny = cur.second + dy[dir];

			if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
			if (board[nx][ny] != 0 || dist[nx][ny] != -1) continue;

			dist[nx][ny] = dist[cur.first][cur.second] + 1;
			Q.push({ nx,ny });
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (dist[i][j] == -1) {
				cout << -1;
				return 0;
			}
		}
	}
	cout << dist[cur.first][cur.second];
}