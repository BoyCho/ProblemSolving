import java.util.*;

class 한_번만_사용한_최초문자 {
    public int solution(String s){
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1)
                return i + 1;
        }
        return -1;
    }

    public static void main(String[] args){
        한_번만_사용한_최초문자 T = new 한_번만_사용한_최초문자();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}