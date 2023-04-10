import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String> Q = new LinkedList<>();
        boolean[] vis = new boolean[words.length];
        
        for (int i = 0; i < words.length; i++) {
            if (getDiff(begin, words[i]) == 1) {
                if (words[i].equals(target)) return 1;
                vis[i] = true;
                Q.add(words[i]);
            }
        }
        
        int L = 1;
        while (!Q.isEmpty()) {
            L++;
            int len = Q.size();
            while (len-- > 0) {
                String cur = Q.poll();

                for (int i = 0; i < words.length; i++) {
                    if (vis[i]) continue;
                    
                    if (getDiff(cur, words[i]) == 1) {
                        if (words[i].equals(target)) return L;
                        vis[i] = true;
                        Q.add(words[i]);
                    }
                }
            }
        }
        return 0;
    }
    
    int getDiff(String beg, String wor) {
        for (int i = 0; i < wor.length(); i++) {
            String s = Character.toString(wor.charAt(i));
            if (beg.contains(s))
                beg = beg.replaceFirst(s, "");
        }
        return beg.length();
    }
}