import java.util.*;
class IP주소 {

    Deque<String> tmp;
    List<String> ans;
    String nums;
    int n;

    public String[] solution(String s){
        tmp = new LinkedList<>();
        ans = new ArrayList<>();
        n = s.length();
        nums = s;

        dfs(0);

        String[] answer = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            answer[i] = ans.get(i);

        return answer;
    }

    void dfs(int d) {
        if (tmp.size() == 4 && d == n) {
            String s = "";
            for (String num : tmp) s += num + ".";

            ans.add(s.substring(0, s.length() - 1));
            return;
        }

        for (int i = d; i < n; i++) {
            if (nums.charAt(d) == '0' && i > d) return;

            String n = nums.substring(d, i + 1);
            if (Integer.parseInt(n) > 255) return;
            tmp.add(n);
            dfs(i + 1);
            tmp.pollLast();
        }
    }

    public static void main(String[] args){
        IP주소 T = new IP주소();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
    }
}