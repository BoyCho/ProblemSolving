import java.util.*;

class 문자열_압축해제 {
    public String solution(String s){
        Stack<String> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != ')') {
                st.push(Character.toString(c));
                continue;
            }
            String str = "";
            while (!st.peek().equals("("))
                str = st.pop() + str;

            st.pop();

            String ns = "";
            while (!st.isEmpty() && Character.isDigit(st.peek().charAt(0)))
                ns = st.pop() + ns;

            int num = ns.equals("") ? 1 : Integer.parseInt(ns);
            String res = "";
            while (num-- > 0) res += str;

            st.push(res);
        }
        String ans = "";
        for (String str : st) ans += str;
        return ans;
    }

    public static void main(String[] args){
        문자열_압축해제 T = new 문자열_압축해제();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }
}