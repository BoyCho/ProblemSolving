import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] vis = new boolean[words.length];
        Queue<String> Q = new LinkedList<>();
        
        Q.add(begin);
        
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            L++;
            while (len-- > 0) {
                String cur = Q.poll();

                for (int i = 0; i < words.length; i++) {
                    if (vis[i]) continue;
                    
                    if (check(cur, words[i])) {
                        if (words[i].equals(target)) return L;
                        vis[i] = true;
                        Q.add(words[i]);
                    }
                }
            }
        }
        return 0;
    }
    
    boolean check(String beg, String wor) {
        int cnt = 0;
        for (int i = 0; i < wor.length(); i++) {
            if (beg.charAt(i) != wor.charAt(i)) {
                if (++cnt > 1) return false;
            }
        }
        return true;
    }
}