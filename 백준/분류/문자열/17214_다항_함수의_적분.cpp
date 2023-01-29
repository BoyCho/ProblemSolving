#include <bits/stdc++.h>

using namespace std;

int main()
{
	string s, sx = "";
	int n;

	cin >> s;

	if (s == "0") {
		cout << "W";
		return 0;
	}

	for (int i = s.size() - 1; i >= 0; i--) {
		if (s[i] == 'x') {
			sx = s.substr(0, i);
			s = s.substr(i + 1, s.size());
			break;
		}
	}

	if (sx != "") {
		n = stoi(sx);
		n /= 2;
		if (n == 1)
			sx = "xx";
		else if (n == -1)
			sx = "-xx";
		else
			sx = to_string(n) + "xx";
	}

	if (s != "") {
		if (s == "1" || s == "+1" || s == "-1")
			s.erase(s.size() - 1, 1);
		sx += s + "x";
	}
	cout << sx + "+W";
}