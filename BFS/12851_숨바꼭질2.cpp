#include <iostream>
#include <queue>

// 카운트 할 때는 거리순으로 한 번에 풀기보단 visit으로 하자
// 특히, 기존 vis를 dist로 사용하면서 이번의 pair를 사용하다보니 거리와 카운트간의 혼동이 있었다
// 정의를 명확히 하자
using namespace std;

bool vis[100002];

int main()
{
	queue<pair<int,int>> Q;
	int N, K;
	int Time = 0, Cnt = 0;

	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> N >> K;

	Q.push({N,0});

	while (!Q.empty()) {
		int cur = Q.front().first; 
		int curTime = Q.front().second;
		Q.pop();
		vis[cur] = 1;
		
		if (cur == K && curTime == Time && Cnt)
			Cnt++;

		if (cur == K && !Cnt) {
			Cnt++;
			Time = curTime;
		}
		
		for (int nxt : {cur - 1, cur + 1, cur * 2}) {
			if (nxt < 0 || nxt > 100000) continue;
			if (vis[nxt]) continue;
			Q.push({ nxt,curTime + 1 });
		}
	}
	cout << Time << endl << Cnt;
}