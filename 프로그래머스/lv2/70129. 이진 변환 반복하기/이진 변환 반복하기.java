class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while (!s.equals("1")) {
            String tmp = "";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') tmp += s.charAt(i);    
            }
            answer[1] += s.length() - tmp.length();
            answer[0]++;
            int n = Integer.parseInt(Integer.toString(tmp.length()), 10);
            
            s = Integer.toString(n, 2);
        }
        
        return answer;
    }
}