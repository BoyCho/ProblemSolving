#include <bits/stdc++.h>

using namespace std;

vector<char> code;
vector<int> tmp;

int main()
{
	int n, m;
	char c;

	cin >> n >> m;
	for (int i = 0; i < n; i++)
		tmp.push_back(1);
	for (int i = n; i < m; i++)
		tmp.push_back(0);

	while (m--) {
		cin >> c;
		code.push_back(c);
	}
	sort(code.begin(), code.end());

	do {
		bool flag1 = false, flag2 = false;
		vector<char> x;
		int cnt = 0;

		for (int i = 0; i < tmp.size(); i++) {
			if (tmp[i] == 1)
				x.push_back(code[i]);
		}
		for (char i : x) {
			if (i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u')
				flag1 = true;
			else
				cnt++;
			if (flag1 && cnt >= 2) {
				flag2 = true;
				break;
			}
		}
		if (flag2) {
			for (char i : x)
				cout << i;
			cout << "\n";
		}
	} while (prev_permutation(tmp.begin(), tmp.end()));
}