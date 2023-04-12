//10:58
import java.util.*;

class Solution {
    
    String[] map;
    int[] parent;
    
    public String[] solution(String[] commands) {
        List<String> ans = new ArrayList<>();
        map = new String[2501];
        parent = new int[2501];
        
        for (int i = 1; i <= 2500; i++) {
            parent[i] = i;
            map[i] = "EMPTY";
        }
        
        int r, c, conv;
        for (String comm : commands) {
            if (comm.split(" ")[0].equals("UPDATE")) {
                String[] s = comm.split(" ");
                
                if (s.length == 4) {
                    r = Integer.parseInt(s[1]);
                    c = Integer.parseInt(s[2]);

                    map[Find(convert(r, c))] = s[3];
                    continue;
                }
                
                for (int i = 1; i <= 2500; i++) {
                    if (map[i].equals(s[1])) 
                        map[i] = s[2];
                }
            }

            if (comm.split(" ")[0].equals("MERGE")) {
                int[] x = new int[4];
                for (int i = 0; i < 4; i++)
                    x[i] = Integer.parseInt(comm.split(" ")[i + 1]);

                int cell1 = convert(x[0], x[1]);
                int cell2 = convert(x[2], x[3]);
                Union(cell1, cell2);
            }

            if (comm.split(" ")[0].equals("UNMERGE")) {
                r = Integer.parseInt(comm.split(" ")[1]);
                c = Integer.parseInt(comm.split(" ")[2]);
                conv = convert(r, c);
                
                int parentCell = Find(conv);
                String value = map[parentCell];
                map[parentCell] = "EMPTY";
                map[conv] = value;
                
                List<Integer> deleteList = new ArrayList<>();
                for (int i = 1; i <= 2500; i++) {
                    if (Find(i) == parentCell) 
                        deleteList.add(i);
                }
                
                for (int i : deleteList)
                    parent[i] = i;
            }

            if (comm.split(" ")[0].equals("PRINT")) {
                r = Integer.parseInt(comm.split(" ")[1]);
                c = Integer.parseInt(comm.split(" ")[2]);
                conv = convert(r, c);
                
                ans.add(map[Find(conv)]);
            }
        }
        return ans.toArray(new String[0]);
    }
    
    int Find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = Find(parent[x]);
    }
    
    void Union(int x, int y) {
        int px = Find(x);
        int py = Find(y);
        
        if (px == py) return;
        
        String value = map[px].equals("EMPTY") ? map[py] : map[px];
        map[px] = "EMPTY";
        map[py] = "EMPTY";
        
        parent[py] = px;
        map[px] = value;
    }
    
    int convert(int r, int c) {
        return (r - 1) * 50 + c;
    }
}