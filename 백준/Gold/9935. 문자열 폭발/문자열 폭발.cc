#include<bits/stdc++.h>

using namespace std;

string in, c4, s;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> in >> c4;

	int size = (int)in.size();
	int c4_size = (int)c4.size();

	for (auto it : in) {

		s.push_back(it);

		if ((int)s.size() < c4_size)
			continue;

		int cur = (int)s.size() - c4_size;
		for (auto c : c4) {
			if (s[cur] != c)
				break;
			cur++;
		}
		if (cur == (int)s.size()) {
			for (auto c : c4)
				s.pop_back();
		}
	}
	if (s.empty())
		cout << "FRULA";
	cout << s;
}