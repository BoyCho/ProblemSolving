import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        
        for (int i = 1; i <= n; i++) map.put(i, new HashSet<>());
        for (int[] wire : wires) {
            map.get(wire[0]).add(wire[1]);
            map.get(wire[1]).add(wire[0]);
        }
        
        for (int i = 0; i < wires.length; i++) {
            boolean[] vis = new boolean[n + 1];
            int[] cnt = new int[2];
            int L = -1;
            
            for (int j = 1; j <= n; j++) {
                if (vis[j]) continue;
                
                Queue<Integer> Q = new LinkedList<>();
                L++;
                
                Q.add(j);
                vis[j] = true;
                cnt[L]++;
                
                while (!Q.isEmpty()) {
                    int cur = Q.poll();
                    
                    for (int x : map.get(cur)) {
                        if (cur == wires[i][0] && x == wires[i][1] ||
                            cur == wires[i][1] && x == wires[i][0] || vis[x]) continue;
                        
                        Q.add(x);
                        vis[x] = true;
                        cnt[L]++;
                    }
                }
            }
            answer = Math.min(answer, Math.abs(cnt[0] - cnt[1]));
        }
        return answer;
    }
}