class 피부과 {
    public int solution(int[] laser, String[] enter){
        int n = enter.length, max = 0;
        int[][] ent = new int[n][2];

        for (int i = 0; i < n; i++) {
            ent[i][0] = getTime(enter[i].split(" ")[0]);
            ent[i][1] = Integer.parseInt(enter[i].split(" ")[1]);
        }

        for (int st = 0, en = 0; st < n; st++) {
            int endT = ent[st][0] + laser[ent[st][1]];
            while(en < n && ent[en][0] < endT) en++;
            max = Math.max(max, en - st - 1);
        }

        return max;
    }

    int getTime(String t) {
        int h = Integer.parseInt(t.split(":")[0]);
        int m = Integer.parseInt(t.split(":")[1]);
        return h * 60 + m;
    }

    public static void main(String[] args){
        피부과 T = new 피부과();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}