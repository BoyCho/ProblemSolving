import java.util.*;

class 최대_길이_바이토닉_수열 {
    public int solution(int[] nums){
        List<Integer> peaks = new ArrayList<>();
        int answer = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1])
                peaks.add(i);
        }

        for (int p : peaks) {
            int cnt = 1;
            int pm = p, pp = p;
            while (pm > 0 && nums[pm - 1] < nums[pm--])
                cnt++;
            while (pp < nums.length - 1 && nums[pp] > nums[pp++ + 1])
                cnt++;
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args){
        최대_길이_바이토닉_수열 T = new 최대_길이_바이토닉_수열();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}