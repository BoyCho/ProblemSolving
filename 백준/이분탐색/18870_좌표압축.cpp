#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	vector<int> uni, input;
	int n, tmp;

	cin >> n;
	while(n--) {
		cin >> tmp; 
		input.push_back(tmp); uni.push_back(tmp);
	}

	sort(uni.begin(), uni.end());
	uni.erase(unique(uni.begin(), uni.end()), uni.end());

	for (int itr : input)
		cout << lower_bound(uni.begin(), uni.end(), itr) - uni.begin() << " ";
}