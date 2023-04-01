import java.util.*;

class 침몰하는_타이타닉 {
    public int solution(int[] nums, int m){
        int answer = 0;

        int st = 0, en = nums.length - 1;

        Arrays.sort(nums);

        while (st <= en) {
            int n = m - nums[en--];
            if (nums[st] <= n) st++;
            answer++;
        }
        return answer;
    }

    public static void main(String[] args){
        침몰하는_타이타닉 T = new 침몰하는_타이타닉();
        System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
        System.out.println(T.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
        System.out.println(T.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
    }
}