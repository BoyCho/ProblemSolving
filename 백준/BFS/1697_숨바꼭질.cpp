#include <iostream>
#include <queue>

using namespace std;

int dist[100002];	// 10000을 초과 후 -1로 동생의 위치에 도달하는 것은 비효율적일 것이므로, 10000쯤으로 설정

int main()
{
	queue<int> Q;
	int N, K;

	cin >> N >> K;
	fill(dist, dist + 100001, -1);

	dist[N] = 0;
	Q.push(N);

	while (dist[K] == -1) {
		int cur = Q.front();
		Q.pop();

		// RangeBased For문
		for (int nxt : {cur - 1, cur + 1, cur * 2}) {
			if (nxt < 0 || nxt > 100000) continue;
			if (dist[nxt] != -1) continue;
			dist[nxt] = dist[cur] + 1;
			Q.push(nxt);
		}
	}
	cout << dist[K];
}