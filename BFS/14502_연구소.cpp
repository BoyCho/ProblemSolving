#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>
#include <map>
using namespace std;

int arr[8][8];
bool vis[8][8];

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	queue<pair<int, int>> q;
	int n, m, size, ans = 0;
	vector<int> zcnt;
	int dx[4] = { 0, -1, 0, 1 };
	int dy[4] = { 1, 0, -1, 0 };
	vector<pair<int,int>> z, two;
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> arr[i][j];
			if (arr[i][j] == 0) z.push_back({ i,j });
			if (arr[i][j] == 2) two.push_back({ i,j });
		}
	}
	size = z.size();
	for (int i = 0; i < 3; i++) zcnt.push_back(1);
	for (int i = 3; i < size; i++) zcnt.push_back(0);
	do {
		vector<int> tmp;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				vis[i][j] = 0;
			}
		}
		for (int i = 0; i < size; i++) {
			if (zcnt[i]) {
				arr[z[i].first][z[i].second] = 1;
				tmp.push_back(i);
			}
		}
		
		for (int i = 0; i < two.size(); i++) {
			q.push({ two[i].first, two[i].second });
			vis[two[i].first][two[i].second] = 1;
		}

		int zeros = size;
		while (!q.empty()) {
			int x = q.front().first; 
			int y = q.front().second;
			q.pop();

			for (int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir]; 
				int ny = y + dy[dir];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				if (vis[nx][ny] || arr[nx][ny]) continue;

				q.push({ nx,ny });
				vis[nx][ny] = 1;
				zeros--;
			}
		}
		ans = max(zeros - 3, ans);
		for (int i = 0; i < tmp.size(); i++) arr[z[tmp[i]].first][z[tmp[i]].second] = 0;
	} while (prev_permutation(zcnt.begin(), zcnt.end()));
	cout << ans;
}