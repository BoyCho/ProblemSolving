import java.util.*;

class Solution {

    boolean[] isUsed;
    List<Integer> arr;
    int n, size, answer;

    public int solution(int n_){

        arr = new ArrayList<>();
        n = n_;

        while (n_ > 0) {
            arr.add(n_ % 10);
            n_ /= 10;
        }
        Collections.sort(arr);
        size = arr.size();
        isUsed = new boolean[size];

        answer = -1;
        dfs(0, 0);
        return answer;
    }

    void dfs(int d, int num) {
        if (d == size) {
            if (num > n) answer = num;
            return;
        }
        if (answer != -1) return;

        for (int i = 0; i < size; i++) {
            if (isUsed[i]) continue;

            isUsed[i] = true;
            dfs(d + 1, num * 10 + arr.get(i));
            isUsed[i] = false;
        }
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}