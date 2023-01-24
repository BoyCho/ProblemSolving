#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

int paper[500][500];
bool vis[500][500];

using namespace std;
int main() {
	queue<pair<int, int>> Q;
	int cnt = 0, res = 0;
	int dx[4] = { 1,0,-1,0 };
	int dy[4] = { 0,1,0,-1 };
	int n, m;

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> paper[i][j];
		}
	}
	/*
	* �ش� ĭ�̰� �湮�� �� ������ ť�� �ֱ�
	* ť�� �ִ� �� �ϳ� ���� �� �� �� �� ���ϱ�
	* ���ϸ鼭 �����ϸ� ť�� �ֱ�
	* ť�� �� ������ �ݺ�
	* 
	* ����1. ť�� ���� �� �湮 ǥ�ø� ����� (�� ��x) - �޸� �ʰ� �߻� ����
	* ����2. �������� �湮 ǥ�ø� �� �����
	* ����3. ������ ������ üũ�Ѵ�
	*/
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (paper[i][j] == 0 || vis[i][j]) continue;
			int breadth = 0;
			cnt++;
			Q.push({ i,j });
			vis[i][j] = 1;
			while (!Q.empty()) {
				breadth++;
				pair<int, int> cur = Q.front();
				Q.pop();
				for (int dir = 0; dir < 4; dir++) {
					int nx, ny;
					nx = cur.first + dx[dir];
					ny = cur.second + dy[dir];

					if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
					if (paper[nx][ny] != 1 || vis[nx][ny]) continue;

					vis[nx][ny] = 1;
					Q.push({ nx,ny });
				}
			}
			if (breadth > res) res = breadth;
		}
	}
	cout << cnt << endl << res << endl;
}