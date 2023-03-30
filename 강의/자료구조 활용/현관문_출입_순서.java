import java.util.*;
class 현관문_출입_순서 {
    public int[] solution(int[] arrival, int[] state){
        int n = arrival.length;
        int[] answer = new int[n];

        Queue<Integer> enter = new LinkedList<>();
        Queue<Integer> exit = new LinkedList<>();
        int prevState = state[0];

        for (int t = 0, i = 0, cnt = 0; cnt < n; t++) {
            if (enter.isEmpty() && exit.isEmpty() && i < n) {
                prevState = 1;  // * 우선 순위 : 1초 후면 나가는 사람 > 들어가는 사람
                t = arrival[i];
            }
            while (i < n && arrival[i] == t) {
                if (state[i] == 1) exit.add(i);
                else enter.add(i);
                i++;
            }
            if (prevState == 0) {
                if (!enter.isEmpty() && arrival[enter.peek()] <= t)
                    answer[enter.poll()] = t;
                else if (!exit.isEmpty() && arrival[exit.peek()] <= t) {
                    answer[exit.poll()] = t;
                    prevState = 1;
                }
            } else {
                if (!exit.isEmpty() && arrival[exit.peek()] <= t)
                    answer[exit.poll()] = t;
                else if (!enter.isEmpty() && arrival[enter.peek()] <= t) {
                    answer[enter.poll()] = t;
                    prevState = 0;
                }
            }
            cnt++;
        }
        return answer;
    }

    public static void main(String[] args){
        현관문_출입_순서 T = new 현관문_출입_순서();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}