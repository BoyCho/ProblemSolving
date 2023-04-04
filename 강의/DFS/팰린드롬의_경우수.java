import java.util.*;
class 팰린드롬의_경우수 {
    Map<Character, Integer> map;
    Deque<Character> deque;
    List<String> ans;
    int n;

    public String[] solution(String s){
        n = s.length();
        map = new HashMap<>();

        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        deque = new LinkedList<>();
        for (char key : map.keySet()) {
            if (map.get(key) % 2 == 1) {
                map.put(key, map.get(key) - 1);
                deque.add(key);
            }
            if (deque.size() > 1) return new String[]{};
        }

        ans = new ArrayList<>();
        dfs();

        String[] answer = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            answer[i] = ans.get(i);
        return answer;
    }

    void dfs() {
        if (deque.size() == n) {
            StringBuilder s = new StringBuilder();
            for (char c : deque) s.append(c);
            ans.add(s.toString());
            return;
        }

        for (char key : map.keySet()) {
            if (map.get(key) == 0) continue;    // map 사용 시 isUsed 처리법

            deque.addFirst(key); deque.addLast(key);
            map.put(key, map.get(key) - 2);
            dfs();
            deque.pollFirst(); deque.pollLast();
            map.put(key, map.get(key) + 2);
        }
    }

    public static void main(String[] args){
        팰린드롬의_경우수 T = new 팰린드롬의_경우수();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }
}