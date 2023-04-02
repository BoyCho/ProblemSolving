import java.util.*;

class 이동_횟수 {
    public int solution(int[] nums){
        int answer = 0;
        int st = 0, en = nums.length - 1;

        Arrays.sort(nums);

        while (st <= en) {
            if (nums[en--] + nums[st] <= 5) st++;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args){
        이동_횟수 T = new 이동_횟수();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
    }
}