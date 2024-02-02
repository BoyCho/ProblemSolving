import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
 
public class Main {
    static int n,m;
    static int []dig;
    static List<Integer> [] lists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []s= br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        lists = new ArrayList[n+1];
        dig = new int[n+1];
        int start;
        int end;
 
        for(int i=1; i<=n; i++){
            lists[i] = new ArrayList<>();
            dig[i] = 0;
        }
 
        for(int i=0; i<m; i++){
            String[] s1 = br.readLine().split(" ");
            start = Integer.parseInt(s1[0]);
            end = Integer.parseInt(s1[1]);
            lists[start].add(end);
            dig[end]++;
        }
        String result = solve();
        System.out.println(result);
    }
 
    private static String solve(){
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> queue  =new PriorityQueue<>();
        for(int i=1; i<=n; i++){
            if(dig[i]==0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            sb.append(poll).append(" ");
            for(Integer now: lists[poll]) {
                dig[now]--;
                if (dig[now] == 0) {
                    queue.add(now);
                }
            }
        }
        return sb.toString();
    }
}