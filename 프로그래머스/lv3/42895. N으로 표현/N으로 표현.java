import java.util.*;

class Solution {
    public int solution(int N, int number) {
        Map<Integer, ArrayList<Integer>> d = new HashMap<>();
        
        for (int i = 1; i <= 8; i++)
            d.put(i, new ArrayList<>());
        
        int L = 0;
        while (++L < 9) {
            int num = 0;
            
            for (int i = 0; i < L; i++)
                num = num * 10 + N;
            
            if (num == number) return L;
            d.get(L).add(num);
            
            for (int i = 1; i <= L / 2; i++) {
                int j = L - i;
                
                for (int x : d.get(i)) {
                    for (int y : d.get(j)) {
                        List<Integer> l = new ArrayList<>();
                        
                        l.add(x + y);
                        l.add(x - y);
                        l.add(y - x);
                        l.add(x * y);
                        if (y != 0) l.add(x / y);
                        if (x != 0) l.add(y / x);
                        
                        for (int z : l) {
                            if (z == number) return L;
                            d.get(L).add(z);
                        }
                    }
                }
            }
        }
        return -1;
    }
}