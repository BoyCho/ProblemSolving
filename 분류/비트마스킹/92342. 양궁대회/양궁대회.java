class Solution {

    static int[] info, ans;
    static int n, total;

    public int[] solution(int n_, int[] info_) {
        int[] answer = {-1};
        int gap = 1;
        
        info = info_;
        n = n_;

        for (int i = 0; i < 11; i++) {
            if (info[i] > 0)
                total += 10 - i;
        }
        for (int i = 0; i < (1 << 11); i++) {
            int getGap = win(make(i));
            if (getGap < gap || (getGap == gap && GapIsLow(answer))) continue;
            if (getGap > gap) gap = getGap;
            answer = ans;
        }
        return answer;
    }

    boolean GapIsLow(int[] ans) {
        if (ans[0] == -1) return false; // 최소 배열 초기화 전일 경우
        
        for (int i = 10; i >= 0; i--) {
            if (ans[i] < Solution.ans[i]) return false;
            else if (ans[i] > Solution.ans[i]) return true;
        }
        return false;
    }
    
    int win(int[] arr) {
        int[] cus = new int[11]; 
        int oriTotal = total;
        int newTotal = 0;
        int n_ = n;

        for (int i = 0; i < 11; i++) {
            if (arr[i] == 0) continue;

            if (info[i] >= n_) {
                cus[i] = n_;
                break;
            } else {
                newTotal += 10 - i;
                cus[i] = info[i] + 1;
                n_ -= info[i] + 1;
                if (info[i] != 0) oriTotal -= 10 - i;
            }
        }
        ans = cus;
        return newTotal - oriTotal;
    }

    int[] make(int n) {
        int[] arr = new int[11];
        int k = 10;

        String s = Integer.toBinaryString(n);

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') arr[k] = 1;
            k--;
        }
        return arr;
    }
}