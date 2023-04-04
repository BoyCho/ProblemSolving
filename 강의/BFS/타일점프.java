import java.util.*;

class 타일점프 {
    public int solution(int[] nums){
        int[] jump = new int[nums.length];
        int n = nums.length;

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while (!q.isEmpty() && jump[n-1] == 0) {
            int cur = q.poll();
            for (int i = 1; i <= nums[cur]; i++) {
                int nCur = cur + i;
                if (nCur >= n) break;
                if (jump[nCur] != 0 && jump[cur] >= jump[nCur]) continue;

                jump[nCur] = jump[cur] + 1;
                q.add(nCur);
            }
        }
        return jump[n-1] == 0 ? -1 : jump[n-1];
    }

    public static void main(String[] args){
        타일점프 T = new 타일점프();
        System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}