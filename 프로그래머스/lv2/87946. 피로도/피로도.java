import java.util.*;

class Solution {
    int answer;
    int[][] dg;
    int[] vis;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        dg = dungeons;
        vis = new int[dg.length];
        dfs(k, 0);
        return answer;
    }
    
    void dfs(int k, int cnt) {
        for (int i = 0; i < dg.length; i++) {
            if (vis[i] == 1 || k < dg[i][0]) continue;
            
            vis[i] = 1;
            dfs(k - dg[i][1], cnt + 1);
            vis[i] = 0;
        }
        answer = Math.max(answer, cnt);
    }
}