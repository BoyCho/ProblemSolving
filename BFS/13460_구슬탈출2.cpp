#include <algorithm>
#include <iostream>
#include <tuple>
#include <queue>
using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	queue<tuple<int, int, int>> r, b;
	string arr[10];
	int n, m, mincnt = 0;
	int dx[4] = { 0, -1, 0, 1 };
	int dy[4] = { 1, 0, -1, 0 };
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
		for (int j = 0; j < arr[i].size(); j++) {
			if (arr[i][j] == 'R') r.push({ 0,i,j });
			if (arr[i][j] == 'B') b.push({ 0,i,j });
		}
	}
	
	while (mincnt < 10 && !r.empty()) {
		int cnt = get<0>(r.front());
		int rx = get<1>(r.front()), ry = get<2>(r.front());
		int bx = get<1>(b.front()), by = get<2>(b.front());
		r.pop(); b.pop();

		
		mincnt = max(mincnt, cnt);
		for (int dir = 0; dir < 4; dir++) {
			bool rflag = false, bflag = false, con = false;
			int rnx = rx, rny = ry;
			int bnx = bx, bny = by;

			while (arr[bnx][bny] != '#') {
				bnx += dx[dir]; bny += dy[dir];
				if (arr[bnx][bny] == 'O') { con = true; break; }
				if (bnx == rx && bny == ry) bflag = true;
			}
			if (con) continue;
			if (bflag) { bnx -= dx[dir]; bny -= dy[dir]; }

			while (arr[rnx][rny] != '#') {
				rnx += dx[dir]; rny += dy[dir];
				if (arr[rnx][rny] == 'O') { cout << cnt + 1; return 0; }
				if (rnx == bx && rny == by) rflag = true;
			}

			if(rflag) { rnx -= dx[dir]; rny -= dy[dir]; }
			
			rnx -= dx[dir]; rny -= dy[dir]; bnx -= dx[dir]; bny -= dy[dir];
			if (rnx == rx && rny == ry && bnx == bx && bny == by) continue;

			r.push({ cnt + 1, rnx, rny });
			b.push({ cnt + 1, bnx, bny });
		}
	}
	cout << -1; return 0;
}