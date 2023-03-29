import java.util.*;
class 같은_빈도수_만들기 {
    public int[] solution(String s){
        HashMap<Character, Integer> sH = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for (char c : s.toCharArray())
            sH.put(c, sH.getOrDefault(c, 0) + 1);

        String tmp = "abcde";

        for (char c : tmp.toCharArray()) {
            if (sH.getOrDefault(c, 0) > max)
                max = sH.get(c);
        }

        int[] answer = new int[5];

        for (int i = 0; i < 5; i++)
            answer[i] = max - sH.getOrDefault(tmp.charAt(i), 0);
        return answer;
    }

    public static void main(String[] args){
        같은_빈도수_만들기 T = new 같은_빈도수_만들기();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
