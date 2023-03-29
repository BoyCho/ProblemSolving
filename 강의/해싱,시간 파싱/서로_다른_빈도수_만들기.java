import java.util.*;

class 서로_다른_빈도수_만들기 {
    public int solution(String s){
        HashMap<Character, Integer> sH = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        int answer = 0;

        for (char key : s.toCharArray())
            sH.put(key, sH.getOrDefault(key, 0) + 1);

        for (int freq : sH.values()) {
            while (set.contains(freq) && freq != 0) {
                freq--;
                answer++;
            }
            if (freq > 0) set.add(freq);
        }

        return answer;
    }

    public static void main(String[] args){
        서로_다른_빈도수_만들기 T = new 서로_다른_빈도수_만들기();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}