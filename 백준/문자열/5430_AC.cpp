#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>

using namespace std;

vector<int> arr;
string p, s;
int T, n;

int main()
{
	cin >> T;

	while (T--) {
		cin >> p >> n >> s;
		arr.clear();

		// func : ���ڿ� �ڸ��� -> ���� �迭�� �����
		s.erase(s.begin());
		s.erase(s.end() - 1);

		stringstream ss(s);
		string num;
		while (getline(ss, num, ','))
			arr.push_back(stoi(num));

		// func : ��� �����ϱ�
		int st = 0, en = n, r = 1;
		bool errorflag = false;

		for (char c : p) {
			if (c == 'D' && st == en) {
				cout << "error" << "\n";
				errorflag = true;
			}
			if (c == 'D')
				r == 1 ? st += r : en += r;
			else
				r == 1 ? r = -1 : r = 1;
		}
		if (errorflag) continue;

		// func : ���� �迭 �����ϱ�
		if (en != n) arr.erase(arr.begin() + en, arr.end());
		arr.erase(arr.begin(), arr.begin() + st);
		// check! �ڿ�������..
		if (r == -1) reverse(arr.begin(), arr.end());

		// func : ���ڿ��� �����
		string res = "";
		for (auto n : arr) res += ',' + to_string(n);
		if (res != "") res.erase(res.begin());
		
		res = '[' + res + ']';

		cout << res << "\n";
	}
}