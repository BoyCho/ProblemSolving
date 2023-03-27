import java.util.*;

class Sort3 {
    public int solution(int[] nums, int k){
        int[] diff = new int[nums.length - 1];
        int answer = 0;

        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 0; i -= 2) {
            diff[i / 2] = nums[i] - nums[i - 1];
            answer += nums[i - 1];
        }
        Arrays.sort(diff);

        for (int i = diff.length - 1; i >= 0; i--) {
            if (k-- == 0) break;
            answer += diff[i];
        }
        return answer;
    }

    public static void main(String[] args){
        Sort3 T = new Sort3();
        System.out.println(T.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
        System.out.println(T.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
        System.out.println(T.solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
        System.out.println(T.solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
        System.out.println(T.solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
    }
}