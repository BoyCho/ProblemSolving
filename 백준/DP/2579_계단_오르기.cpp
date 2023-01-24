#include <iostream>

using namespace std;
// 1. �� ���� �������� �� �� �ö�Դ���, �� �� �ö�Դ��� Ȯ���Ͽ� �ִ밪�� ���ϴ� ��� (2���� �迭 ���)
/*
int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	int d[301][2] = { 0 };
	int S[301];
	int n;

	cin >> n;

	for (int i = 1; i <= n; i++)
		cin >> S[i];

	d[1][1] = S[1];
	d[2][1] = S[2];
	d[2][2] = d[1][1] + S[2];

	for (int i = 3; i <= n; i++) {
		d[i][1] = max(d[i - 2][1], d[i - 2][2]) + S[i];
		d[i][2] = d[i - 1][1] + S[i];
	}

	cout << max(d[n][1], d[n][2]);
}
*/

// �����ս�����, �� ���� ĭ�� Ȯ���Ͽ� �ּҰ��� ���� �տ��� ���� ��� (1���� �迭)
int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	int d[301] = { 0 };
	int S[301];
	int sum = 0, n;

	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> S[i];
		sum += S[i];
	}

	d[1] = S[1];
	d[2] = S[2];
	d[3] = S[3];

	for (int i = 4; i <= n; i++) 
		d[i] = min(d[i - 3], d[i - 2]) + S[i];
	
	cout << sum - min(d[n - 1], d[n - 2]);
}