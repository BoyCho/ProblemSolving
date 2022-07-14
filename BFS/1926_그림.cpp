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
	* 해당 칸이고 방문한 적 없으면 큐에 넣기
	* 큐에 있는 거 하나 빼서 상 하 좌 우 비교하기
	* 비교하면서 성립하면 큐에 넣기
	* 큐가 빌 때까지 반복
	* 
	* 주의1. 큐에 넣을 때 방문 표시를 남긴다 (뺄 때x) - 메모리 초과 발생 가능
	* 주의2. 시작점에 방문 표시를 꼭 남긴다
	* 주의3. 원소의 범위를 체크한다
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