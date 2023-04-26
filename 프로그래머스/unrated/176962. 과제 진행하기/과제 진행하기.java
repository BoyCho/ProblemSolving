//20:05
import java.util.*;

class Solution {
    
    class Subject{
        String name;
        int T;
        
        Subject(String name, int T) {
            this.name = name;
            this.T = T;
        }
    }
    
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        
        Arrays.sort(plans, (String[] a, String[] b) -> a[1].compareTo(b[1]));
        Stack<Subject> St = new Stack<>();
        
        int curT = convert(plans[0][1]);
        
        for (String[] next: plans) {
            int nextT = convert(next[1]);
            int ingT = nextT - curT;
            
            while (!St.isEmpty() && ingT >= St.peek().T) {
                ingT -= St.peek().T;
                answer.add(St.pop().name);
            }
            
            if (!St.isEmpty()) St.peek().T -= ingT;
            curT = nextT;
            St.push(new Subject(next[0], Integer.parseInt(next[2])));
        }
        
        while (!St.isEmpty()) answer.add(St.pop().name);
        return answer.toArray(new String[0]);
    }
    
    int convert(String T) {
        StringTokenizer st = new StringTokenizer(T, ":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        return h * 60 + m;
    }
}