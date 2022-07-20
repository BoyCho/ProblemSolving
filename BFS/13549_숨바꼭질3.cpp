#include <iostream>
#include <climits>
#include <queue>

using namespace std;

/*
* 숨바꼭질2와 다른 점 : 중복을 처리하며 최적의 경우를 찾으면 된다 -> pop 후에 조건을 걸어 큐 empty까지 답을 받아낸다
* 같은 시작점에서 -1 +1 x2 중에서
* x 2를 하면서 동생을 추월한 경우, (0,3)과 같은 경우를 제외하고는(이건 같음) x + 1을 하면서 오는 것보다 느리다
*  = 도착을 늦게 했는데 시간이 더 빠를 경우는 없다 -> pop후 vis 체크하면서 시간을 본다
*/

bool vis[100002];

int main()
{
	queue<pair<int, int>> Q;	// 위치/시간
	int minTime = INT_MAX;
	int n, k;

	cin >> n >> k;

	if (n >= k) {
		cout << n - k;		// 그리디
		return 0;
	}

	Q.push({ n,0 });

	while (!Q.empty()) {

		int x = Q.front().first;
		int t = Q.front().second;
		Q.pop();

		vis[x] = true;

		if (x == k) 
			if (t < minTime) minTime = t;

		if (vis[k]) continue;	// 더 이상 큐에 들어가지 못함

		for (int nxt : {x - 1, x + 1, x * 2}) {

			if (nxt < 0 || nxt > 100000) continue;

			if (nxt == x * 2)
				Q.push({ nxt, t });
			else
				Q.push({ nxt, t + 1 });
		}
	}
	cout << minTime;
}