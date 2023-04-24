import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (int[] a, int[] b) -> 
                   a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        PriorityQueue<int[]> Q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        for (int[] cur : targets) {
            if (Q.isEmpty() || Q.peek()[1] > cur[0]) {
                Q.add(cur);
                continue;
            }
            
            while (!Q.isEmpty() && Q.peek()[0] < cur[0]) Q.poll();
            Q.add(cur);
            answer++;
        }
        return Q.isEmpty() ? answer : answer + 1;
    }
}