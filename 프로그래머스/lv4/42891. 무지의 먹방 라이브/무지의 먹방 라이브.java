import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        int n = food_times.length;
        
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++)
            arr[i+1] = food_times[i];
        
        Arrays.sort(arr);
        int target = 0;
        
        int size = n;
        for (int i = 1; i <= n; i++) {
            if (k < (long)(arr[i] - arr[i-1]) * size) {
                target = arr[i-1];
                break;
            }
            k -= (long)(arr[i] - arr[i-1]) * size--;
        }
        if (size == 0) return -1;
        
        k = k % size;
        for (int i = 0; i < n; i++) {
            if (food_times[i] <= target) continue;
            if (k-- <= 0) return i + 1;
        }
        return -1;
    }
}