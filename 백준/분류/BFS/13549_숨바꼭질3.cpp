#include <iostream>
#include <climits>
#include <queue>

using namespace std;

/*
* ���ٲ���2�� �ٸ� �� : �ߺ��� ó���ϸ� ������ ��츦 ã���� �ȴ� -> pop �Ŀ� ������ �ɾ� ť empty���� ���� �޾Ƴ���
* ���� ���������� -1 +1 x2 �߿���
* x 2�� �ϸ鼭 ������ �߿��� ���, (0,3)�� ���� ��츦 �����ϰ��(�̰� ����) x + 1�� �ϸ鼭 ���� �ͺ��� ������
*  = ������ �ʰ� �ߴµ� �ð��� �� ���� ���� ���� -> pop�� vis üũ�ϸ鼭 �ð��� ����
*/

bool vis[100002];

int main()
{
	queue<pair<int, int>> Q;	// ��ġ/�ð�
	int minTime = INT_MAX;
	int n, k;

	cin >> n >> k;

	if (n >= k) {
		cout << n - k;		// �׸���
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

		if (vis[k]) continue;	// �� �̻� ť�� ���� ����

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