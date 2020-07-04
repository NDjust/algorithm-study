#include <bits/stdc++.h>
using namespace std;

vector<int> adj[5000];
int cnt[5000], dfsn[5000], dcnt;

int dfs(int now, int prv) {
	int tmp, ret = dfsn[now] = dcnt++;

	for (int nxt : adj[now]) if (nxt != prv) {
		if (dfsn[nxt] == -1) tmp = dfs(nxt, now);
		else {
			tmp = dfsn[nxt];
			if (tmp > dfsn[now]) continue;
		}

		if (tmp >= dfsn[now]) ++cnt[now];
		ret = min(ret, tmp);
	}

	if (prv == -1) cnt[now] = max(0, cnt[now] - 1);
	return ret;
}
int solution(int n, vector<vector<int>> edges) {
	for (auto &i : edges) {
		adj[--i[0]].push_back(--i[1]);
		adj[i[1]].push_back(i[0]);
	}

	memset(dfsn, -1, sizeof(dfsn));
	dfs(0, -1);

	int ans = 0;
	for (int i = 0; i < n; ++i)
		if (edges.size() - adj[i].size() + cnt[i] < n - 1) ans += i + 1;

	return ans;
}

int main() {
	cout << solution(4, { { 1, 2 }, { 1, 3 }, { 2, 3 }, { 2, 4 }, { 3, 4 } });
	return 0;
}