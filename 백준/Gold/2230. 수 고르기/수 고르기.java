import java.io.*;
import java.util.*; 

public class Main {	
    public static void main(String[] args) throws IOException{		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
        StringTokenizer st = new StringTokenizer(br.readLine());		
        
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());		
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++)			
            arr[i]=Integer.parseInt(br.readLine());		
        
        Arrays.sort(arr);	
        
        int s=0, e=0, ans=Integer.MAX_VALUE;		
        while(s<=e && e<n) {			
            if(arr[e]-arr[s]>=m) {				
                ans=Math.min(ans, arr[e]-arr[s]);				
                s++;			
            }			
            else				
                e++;		
        }		
        System.out.println(ans);	
    }
}