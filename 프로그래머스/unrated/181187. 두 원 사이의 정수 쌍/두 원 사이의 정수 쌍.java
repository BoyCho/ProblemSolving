class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for (int i = 0; i <= r2; i++) {
            int st = 0, en = r2 + 1;
            
            while (st < en) {
                int mid = (st + en) / 2;
                double dist = Math.sqrt((long)i * i + (long)mid * mid);
                
                if (dist > r2)
                    en = mid;
                else
                    st = mid + 1;
            }
            answer += en;
        }
        
        for (int i = 0; i <= r1; i++) {
            int st = 0, en = r1 + 1;
            
            while (st < en) {
                int mid = (st + en) / 2;
                double dist = Math.sqrt((long)i * i + (long)mid * mid);
                
                if (dist > r1)
                    en = mid;
                else
                    st = mid + 1;
            }
            answer -= en;
            if (Math.sqrt((long)i * i + (long)(en - 1) * (en - 1)) == r1) answer++;
        }
        return answer * 4 - (r2 - r1 + 1) * 4;
    }
}