import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long st = 0, en = (long) times[times.length -1] * n;
        while (st < en) {
            long mid = (st + en) / 2;
            long sum = 0;
            
            for (int i = 0; i < times.length; i++) 
                sum += mid / times[i];
            
            if (sum >= n)
                en = mid;
            else
                st = mid + 1;
        }
        return en;
    }
}