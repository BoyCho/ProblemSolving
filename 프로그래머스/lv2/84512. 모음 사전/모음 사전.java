import java.util.*;

class Solution {
    char[] arr;
    int cnt, answer;
    boolean find;
    String word;
    
    public int solution(String word_) {
        arr = new char[]{'A','E','I','O','U'};
        word = word_;
        dfs("");
        
        return answer;
    }
    
    void dfs(String s) {
        if (find) return;
        
        if (s.equals(word)) {
            answer = cnt;
            find = true;
            return;
        }
        if (s.length() > 5) return;
    
        cnt++;
        
        for (int i = 0; i < 5; i++)
            dfs(s + arr[i]);
    }
}