import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0, sequence.length - 1};
        
        Map <Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        int sum = 0;
        
        for (int i = 0; i < sequence.length; i++) {
            sum += sequence[i];
            map.put(sum, i + 1);
            
            if (map.get(sum - k) == null) continue;
            if (i - map.get(sum - k) < answer[1] - answer[0]) {
                answer[0] = map.get(sum - k);
                answer[1] = i;
            }
        }
        
        
        return answer;
    }
}