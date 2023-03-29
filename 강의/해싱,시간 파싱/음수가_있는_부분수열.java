import java.util.*;

class 음수가_있는_부분수열 {
    public int solution(int[] nums, int m){
        HashMap<Integer, Integer> nH = new HashMap<>();
        int sum = 0, answer = 0;

        for (int n : nums) {
            sum += n;

            if (sum == m) answer++;
            if (nH.get(sum - m) != null) answer += nH.get(sum - m);

            nH.put(sum, nH.getOrDefault(sum, 0) + 1);
        }
        return answer;
    }

    public static void main(String[] args){
        음수가_있는_부분수열 T = new 음수가_있는_부분수열();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}