import java.util.*;

class 최대_길이_연속수열 {
    public int solution(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        int max = 0;
        for (int n : set) {
            if (set.contains(n-1)) continue;

            int cnt = 0;
            while (set.contains(n++))
                cnt++;
            max = Math.max(max, cnt);
        }
        return max;
    }

    public static void main(String[] args){
        최대_길이_연속수열 T = new 최대_길이_연속수열();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}