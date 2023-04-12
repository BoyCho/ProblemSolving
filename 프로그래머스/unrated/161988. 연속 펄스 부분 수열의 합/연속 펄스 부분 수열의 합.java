import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        // 짝수 때 +: 0, 홀수 때 +: 1
        long[][] sum = new long[2][sequence.length + 1];
        
        long nowMin1, nowMax1, nowMin2, nowMax2, diff1, diff2;
        diff1 = nowMin1 = nowMax1 = sequence[0];
        diff2 = nowMin2 = nowMax2 = sequence[0] * -1;
        
        int idxMin1, idxMin2, idxMax1, idxMax2;
        idxMin1 = idxMin2 = idxMax1 = idxMax2 = 0;
        
        for (int i = 0; i < sequence.length; i++) {
            int x1 = 1, x2 = 1;
            if (i % 2 == 0) 
                x2 *= -1;
            else 
                x1 *= -1;
            
            sum[0][i + 1] = sum[0][i] + sequence[i] * x1;
            if (sum[0][i + 1] < nowMin1) {
                nowMin1 = sum[0][i + 1];
                idxMin1 = i + 1;
            }
            if (sum[0][i + 1] > nowMax1) {
                nowMax1 = sum[0][i + 1];
                idxMax1 = i + 1;
            }
            if (idxMax1 > idxMin1)
                diff1 = Math.max(diff1, nowMax1 - nowMin1);
            diff1 = Math.max(diff1, nowMax1);
            
            sum[1][i + 1] = sum[1][i] + sequence[i] * x2;
            if (sum[1][i + 1] < nowMin2) {
                nowMin2 = sum[1][i + 1];
                idxMin2 = i + 1;
            }
            if (sum[1][i + 1] > nowMax2) {
                nowMax2 = sum[1][i + 1];
                idxMax2 = i + 1;
            }
            if (idxMax2 > idxMin2)
                diff2 = Math.max(diff2, nowMax2 - nowMin2);
            diff2 = Math.max(diff2, nowMax2);
        }
        return Math.max(diff1, diff2);
    }
}