import java.util.*;
class Sort2 {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length / 2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);

        Arrays.sort(nums);

        int i = 0;
        for (int n : nums) {
            if (map.get(n) == 0) continue;

            answer[i++] = n;
            map.put(n, map.get(n) - 1);
            map.put(n * 2, map.get(n * 2) - 1);
        }
        return answer;
    }

    public static void main(String[] args){
        Sort2 T = new Sort2();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}