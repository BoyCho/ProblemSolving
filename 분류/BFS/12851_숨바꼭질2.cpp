#include <iostream>
#include <queue>

// ī��Ʈ �� ���� �Ÿ������� �� ���� Ǯ�⺸�� visit���� ����
// Ư��, ���� vis�� dist�� ����ϸ鼭 �̹��� pair�� ����ϴٺ��� �Ÿ��� ī��Ʈ���� ȥ���� �־���
// ���Ǹ� ��Ȯ�� ����
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