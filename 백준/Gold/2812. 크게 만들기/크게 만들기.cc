#include <iostream>
#include <string>
#include <vector>
#include <stack>

using namespace std;

int main() {
	stack<char> stk;
	string s, res;
	int n, k;
	cin >> n;
	cin >> k;
	cin >> s;

	for (int i = 0; i < n; i++) {
		if (k > 0) {
			if (stk.empty())
				stk.push(s[i]);
			else {
				while (s[i] > stk.top()) {
					stk.pop();
					k--;
					if (!k || stk.empty()) break;
				}
				stk.push(s[i]);
			}
		}
		else {
			res = s.substr(i, n - i);
			break;
		}
	}
	for (int i = 0; i < k; i++)
		stk.pop();
	while (!stk.empty()) {
		res = stk.top() + res;
		stk.pop();
	}
	cout << res << endl;
}