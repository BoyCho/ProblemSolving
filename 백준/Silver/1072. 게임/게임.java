import java.io.*;
import java.util.*;
public class Main {
    
    public static void main(String[] args) throws  IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        String [] t = br.readLine().split(" ");
        long x = Long.parseLong(t[0]);
        long y = Long.parseLong(t[1]);
        
        long rate = y*100/x;
        
        if(rate ==100 || rate ==99) {
            System.out.println(-1);
            return ;
        }
        long start = 1;
        long end = (int)x;
        
        // upper_bound
        while(start<end) {
            long mid = (start+end)/2;
            
            long tmp_x = x+mid;
            long tmp_y = y+mid;
            
            long change_rate = tmp_y*100 /tmp_x;
            if(change_rate > rate) {
                end = mid;
            }
            else {
                start = mid+1;
            }
        }
        System.out.println(end);
    }
}