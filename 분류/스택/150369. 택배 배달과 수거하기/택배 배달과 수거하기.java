class Solution {
    
    private int cur;
    
    public long solution(int cap, int n, int[] d, int[] p) {
        
        long dist = 0;
        cur = n - 1;
    
        while(true) {
            for (int i = cur; i >= 0; i--) {
                if (d[i] > 0 || p[i] > 0) {
                    cur = i;
                    break;
                }
                if (i == 0) return dist;
            }
            
            dist += (cur + 1) * 2;
            
            dAndp(cap, d);
            dAndp(cap, p);
        }
    }
    
    public void dAndp(int cap, int[] arr) {
        for (int i = cur; i >= 0; i--) {
            if (arr[i] == 0) continue;
            
            if (cap < arr[i]) {
                arr[i] -= cap;
                return;
            }
            cap -= arr[i];
            arr[i] = 0;
            
            if (cap == 0) return;
        }
    }
}