import java.util.*;
class Sort4 {
    public int solution(int[] score, int k){
        Queue<Integer> q = new LinkedList<>();

        Arrays.sort(score);
        for (int n : score) {
            q.add(n);
            if (q.size() == k) {
                if (n - q.peek() > 10)
                    q.poll();
                else
                    break;
            }
        }
        int answer = 0;

        while (!q.isEmpty()) answer += q.poll();
        return answer / k;
    }

    public static void main(String[] args){
        Sort4 T = new Sort4();
        System.out.println(T.solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3));
        System.out.println(T.solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4));
        System.out.println(T.solution(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5));
        System.out.println(T.solution(new int[]{88, 99, 91, 89, 90, 72, 75, 94, 95, 100}, 5));
    }
}