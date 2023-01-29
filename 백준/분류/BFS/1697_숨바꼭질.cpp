#include <iostream>
#include <queue>

using namespace std;

int dist[100002];	// 10000�� �ʰ� �� -1�� ������ ��ġ�� �����ϴ� ���� ��ȿ������ ���̹Ƿ�, 10000������ ����

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

		// RangeBased For��
		for (int nxt : {cur - 1, cur + 1, cur * 2}) {
			if (nxt < 0 || nxt > 100000) continue;
			if (dist[nxt] != -1) continue;
			dist[nxt] = dist[cur] + 1;
			Q.push(nxt);
		}
	}
	cout << dist[K];
}