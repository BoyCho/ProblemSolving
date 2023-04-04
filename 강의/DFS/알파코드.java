import java.util.*;

class 알파코드 {

    String nums;
    int n, answer;

    public int solution(String s) {
        n = s.length();
        nums = s;
        answer = 0;

        dfs(0);

        return answer;
    }

    void dfs(int d) {
        if (d == n) {
            answer++;
            return;
        }
        int n1 = nums.charAt(d) - '0';
        if (n1 == 0) return;
        dfs(d + 1);

        if (d + 1 == n) return;
        int n2 = n1 * 10 + (nums.charAt(d + 1) - '0');
        if (n2 > 26) return;
        dfs(d + 2);
    }
    public static void main(String[] args){
        알파코드 T = new 알파코드();
        System.out.println(T.solution("25114"));
        System.out.println(T.solution("23251232"));
        System.out.println(T.solution("21020132"));
        System.out.println(T.solution("21350"));
        System.out.println(T.solution("120225"));
        System.out.println(T.solution("232012521"));
    }
}