import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] vis = new boolean[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;

            cnt++;
            Queue<Integer> que = new LinkedList<>();
            que.add(i);
            vis[i] = true;

            while(!que.isEmpty()) {
                int k = que.poll();
                for (int j = 0; j < n; j++) {
                    if (computers[k][j] == 1 && !vis[j]) {
                        que.add(j);
                        vis[j] = true;
                    }
                }
            }
        }
        return cnt;
    }
}