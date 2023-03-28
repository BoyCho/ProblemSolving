class 과일_가져가기 {
    public int solution(int[][] fruit) {
        int answer = 0, n = fruit.length;
        boolean[] change = new boolean[n];
        int[] minIdx = new int[n];

        for (int i = 0; i < n; i++)
            minIdx[i] = getMinIdx(fruit[i]);

        for (int i = 0; i < n; i++) {
            if (change[i] || minIdx[i] == -1) continue;
            for (int j = 0; j < n; j++) {
                if (i == j || change[j] || minIdx[j] == -1) continue;

                if (minIdx[i] != minIdx[j]) {
                    if (fruit[i][minIdx[j]] - fruit[i][minIdx[i]] == 1 ||
                            fruit[j][minIdx[i]] - fruit[j][minIdx[j]] == 1)
                        continue;

                    fruit[j][minIdx[j]]++;
                    fruit[i][minIdx[j]]--;

                    fruit[i][minIdx[i]]++;
                    fruit[j][minIdx[i]]--;

                    change[i] = change[j] = true;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (minIdx[i] == -1) answer += Math.min(Math.min(fruit[i][0], fruit[i][1]), Math.min(fruit[i][0], fruit[i][2]));
            else answer += fruit[i][minIdx[i]];
        }

        return answer;
    }
    int getMinIdx(int[] basket) {
        if (basket[0] == basket[1] || basket[0] == basket[2] || basket[1] == basket[2])
            return -1;
        if (basket[0] < basket[1] && basket[0] < basket[2])
            return 0;
        if (basket[1] < basket[0] && basket[1] < basket[2])
            return 1;
        return 2;
    }

    public static void main(String[] args){
        과일_가져가기 T = new 과일_가져가기();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}