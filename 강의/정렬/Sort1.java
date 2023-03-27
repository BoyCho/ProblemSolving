import java.util.*;
class Sort1 {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length];
        int[][] arr = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            String s = Integer.toBinaryString(nums[i]);
            int cnt = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1')
                    cnt++;
            }
            arr[i][1] = cnt;
        }

        Arrays.sort(arr, (int[] a1, int[] a2) -> a1[1] == a2[1] ? a1[0] - a2[0] : a1[1] - a2[1]);
        for(int i = 0; i < nums.length; i++)
            answer[i] = arr[i][0];

        return answer;
    }

    public static void main(String[] args){
        Sort1 T = new Sort1();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}