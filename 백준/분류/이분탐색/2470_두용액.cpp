// upper_bound와 lower_bound의 이해

#include <algorithm>
#include <iostream>
#include <cstdlib>

using namespace std;

long long p[100001], m[100001];	// p : 양, m : 음
int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	long long tmp, gap = 1000000001, x, y;	
	// gap : 0과 가까운 정도를 담는 변수 
	// x,y : 답을 담을 변수
	int n, i = 0, j = 0;
	// i : 양수 갯수, j : 음수 갯수

	cin >> n;
	for (int k = 0; k < n; k++) {
		cin >> tmp;
		if (tmp < 0) m[i++] = -1 * tmp;
		else p[j++] = tmp;
	}
	
	sort(p, p + j);
	sort(m, m + i);

	// 
	if (!i) {
		cout << p[0] << " " << p[1];
		return 0;
	}
	if (!j) {
		cout << -1 * m[1] << " " << -1 * m[0];
		return 0;
	}
	for (int k = 0; k < j; k++) {
		long long up = upper_bound(m, m + i, p[k]) - m;
		if (up == i) up--;
		long long gap_low = abs(p[k] - m[up]);
		if (up > 0 && abs(p[k] - m[up - 1]) < abs(p[k] - m[up]))
			gap_low = abs(p[k] - m[--up]);

		if (gap_low < gap) {
			gap = gap_low; x = p[k]; y = m[up] * -1;
		}
		if (!gap) break;
	}

	if (j > 1 && p[0] + p[1] < gap) { gap = p[0] + p[1];  y = p[0]; x = p[1]; }
	if (i > 1 && m[0] + m[1] < gap) { y = -1 * m[1]; x = -1 * m[0]; }

	cout << y << " " << x;
}
