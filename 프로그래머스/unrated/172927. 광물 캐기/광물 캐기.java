import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        
        HashMap<String, Integer> cost = new HashMap<>();
        cost.put("diamond", 25);
        cost.put("iron", 5);
        cost.put("stone", 1);
        
        LinkedList<int[]> L = new LinkedList<>();
        
        int sum = cost.get(minerals[0]), j = 0;
        for (int i = 1; i < minerals.length; i++) {
            if (i % 5 == 0) {
                L.add(new int[]{sum, j, i - 1});
                sum = 0;
                j = i;
            }
            sum += cost.get(minerals[i]);
        }
        if (j < minerals.length) L.add(new int[]{sum, j, minerals.length - 1});
        
        int pickSize = 0;
        for (int p: picks) pickSize += p;
        while (L.size() > pickSize) L.pollLast();
        
        Collections.sort(L, (int[] a, int[] b) -> b[0] - a[0]);

        int answer = 0, cur = 0;
        while (true) {
            if (cur > 2 || L.isEmpty()) return answer;
            if (picks[cur] == 0) {
                cur++; continue;
            }
            
            picks[cur]--;
            int[] curL = L.pollFirst();
            for (int i = curL[1]; i <= curL[2]; i++) {
                if (cur == 0) answer += 1;
                if (cur == 1) answer += Math.max(cost.get(minerals[i]) / 5, 1);
                if (cur == 2) answer += cost.get(minerals[i]);
            }
        }
    }
}