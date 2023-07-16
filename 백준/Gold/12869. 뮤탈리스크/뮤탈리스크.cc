#include<algorithm>
#include<iostream>
#include<vector>
#include<tuple>
#include<queue>

using namespace std;

int dist[61][61][61];


int main()
{
	vector<int> mutalisk = { 1,3,9 };
	queue < tuple<int, int, int>> Q;
	int scv[3] = { 0 };
	int n;

	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> n;

	for (int i = 0; i < n; i++)
		cin >> scv[i];

	Q.push({ scv[0],scv[1],scv[2] });
	while (!dist[0][0][0]) {

		tuple<int, int, int> t = Q.front(); Q.pop();

		do {
			int a = get<0>(t) - mutalisk[0] < 0 ? 0 : get<0>(t) - mutalisk[0];
			int b = get<1>(t) - mutalisk[1] < 0 ? 0 : get<1>(t) - mutalisk[1];
			int c = get<2>(t) - mutalisk[2] < 0 ? 0 : get<2>(t) - mutalisk[2];

			if (dist[a][b][c] != 0) continue;

			dist[a][b][c] = dist[get<0>(t)][get<1>(t)][get<2>(t)] + 1;
			Q.push({ a,b,c });

		} while (next_permutation(mutalisk.begin(), mutalisk.end()));
	}
	cout << dist[0][0][0];
}