import java.util.*;

class Solution {
    
    String binary;
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        int idx = 0;
        
        for (long n : numbers) {
            binary = Long.toBinaryString(n);
            
            int len = binary.length();
            int cnt = 0;
            while(true) {
                if (Math.pow(2,cnt) <= len && len < Math.pow(2, cnt + 1)) {
                    int limit = (int)Math.pow(2, cnt + 1) - 1;
                    while (len++ < limit) binary = '0' + binary;
                    break;
                }
                cnt++;
            }
            
            Queue<Integer> queue = new LinkedList<>();
            
            for (int i = 0; i < binary.length(); i+=2) queue.add(i);
            
            answer[idx++] = check(new LinkedList<>(queue));
        }
        
        return answer;
    }
    
    int check(Queue<Integer> q) {
        while(q.size() > 1) {
            Queue<Integer> tmp = new LinkedList<>();
            
            while(!q.isEmpty()) {
                int a = q.poll();
                int b = q.poll();

                if ((binary.charAt(a) == '1' || binary.charAt(b) == '1') && 
                    binary.charAt((a + b) / 2) == '0') return 0;
                
                tmp.add((a + b) / 2);
            }
            q = new LinkedList<>(tmp);
        }
        if (q.poll() == '0') return 0;
        return 1;
    }
}