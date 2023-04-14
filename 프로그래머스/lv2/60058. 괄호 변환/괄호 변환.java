import java.util.*;

class Solution {
    public String solution(String p) {
        return func(p);
    }
    String func(String w) {
        if (w.equals("")) return "";
        
        Stack<Character> st = new Stack<>();
        st.add(w.charAt(0));
        
        int i = 1;  // balance
        while (!st.isEmpty()) {
            if (i == w.length()) break;
            if (w.charAt(i) == st.peek()) 
                st.add(w.charAt(i));
            else
                st.pop();
            i++;
        }
        
        String u = w.substring(0, i);
        String v = i == w.length() ? "" : w.substring(i, w.length());
        
        
        if (check(u)) 
            return u + func(v);
        
        String tmp = "(" + func(v) + ")";
        for (int j = 1; j < u.length() - 1; j++) {
            if (u.charAt(j) == '(') tmp += ')';
            else tmp += '(';
        }
        return tmp;
    }
    
    boolean check(String s) {
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.add('(');
                continue;
            }
            if (st.isEmpty())
                return false;
            st.pop();
        }
        return true;
    }
}