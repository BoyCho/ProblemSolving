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

		// func : 문자열 자르기 -> 정수 배열로 만들기
		s.erase(s.begin());
		s.erase(s.end() - 1);

		stringstream ss(s);
		string num;
		while (getline(ss, num, ','))
			arr.push_back(stoi(num));

		// func : 명령 수행하기
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

		// func : 정수 배열 수정하기
		if (en != n) arr.erase(arr.begin() + en, arr.end());
		arr.erase(arr.begin(), arr.begin() + st);
		// check! 뒤에서부터..
		if (r == -1) reverse(arr.begin(), arr.end());

		// func : 문자열로 만들기
		string res = "";
		for (auto n : arr) res += ',' + to_string(n);
		if (res != "") res.erase(res.begin());
		
		res = '[' + res + ']';

		cout << res << "\n";
	}
}