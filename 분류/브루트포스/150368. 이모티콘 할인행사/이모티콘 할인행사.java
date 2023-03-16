import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    static int n, m;
    static int[] emoticons;
    static int[][] users;
    static List<Answer> answers;

    static class Answer {
        private int cnt;
        private int total;

        public Answer(int cnt, int total) {
            this.cnt = cnt;
            this.total = total;
        }
    }

    public int[] solution(int[][] users_, int[] emoticons_) {
        answers = new ArrayList<>();
        users = users_;
        emoticons = emoticons_;

        n = users.length;
        m = emoticons.length;
        
        func(new ArrayList<>());
        
        answers.sort((Answer a1, Answer a2) -> {
            if (a1.cnt == a2.cnt)
                return a2.total - a1.total;
            return a2.cnt - a1.cnt;
        });
        return new int[] {answers.get(0).cnt, answers.get(0).total};
    }

    static void func(List<Integer> list) {
        if (list.size() == m) {
            
            cal(new ArrayList<>(list));
            return;
        }
        for (int i = 1; i <= 4; i++) {
            list.add(i * 10);
            func(new ArrayList<>(list));
            list.remove(list.size()-1);
        }
    }

    static void cal(List<Integer> list) {
        int cnt = 0, total = 0;
        for (int[] user : users) {
            int userTotal = 0;
            for (int i = 0; i < m; i++) {
                if (list.get(i) >= user[0])
                    userTotal += emoticons[i] - emoticons[i] * list.get(i) / 100;
            }
            if (userTotal >= user[1]) cnt++;
            else total += userTotal;
        }
        answers.add(new Answer(cnt, total));
    }
}