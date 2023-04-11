import java.util.*;

class Solution {
    public int solution(int[] food_time, long k) {
        int answer = 0;
        long n = food_time.length;
        long size = n;
        
        int[] food_times = food_time.clone();
        Arrays.sort(food_times);
        long t = 0;
        
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (k < (long)food_times[i] * size) {
                    t = 0;
                    break;
                }
            }
            else {
                if (k < ((long)food_times[i] - (long)food_times[i-1]) * size) {
                    t = food_times[i-1];
                    break;
                }
            }
            
            if (i == 0) k -= (long)food_times[i] * size--;
            else k -= ((long)food_times[i] - (long)food_times[i-1]) * size--;
        }
        if (size == 0) return -1;
        k = k % size;
        for (int i = 0; i < n; i++) {
            if (food_time[i] <= t) continue;
            if (k-- <= 0) {
                return i + 1;
            }
        }
            
        return -1;
    }
}