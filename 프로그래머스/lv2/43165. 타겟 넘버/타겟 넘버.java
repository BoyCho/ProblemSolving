class Solution {
    
    int n, t, answer;
    int[] nums;
    
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        t = target;
        
        nums = numbers;
        
        answer = 0;
        dfs(0, 0);
        
        return answer;
    }
    
    void dfs(int d, int sum) {
        if (d == n) {
            if (sum == t) answer++;
            return;
        }
        dfs(d + 1, sum + nums[d]);
        dfs(d + 1, sum - nums[d]);
    }
}