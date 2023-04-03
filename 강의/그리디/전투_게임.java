import java.util.*;
class 전투_게임 {
    static class Student {
        int idx;
        int attack;
        char team;

        Student(int idx, int attack, char team) {
            this.idx = idx;
            this.attack = attack;
            this.team = team;
        }
    }
    public int[] solution(String[] students){
        int n = students.length;
        int[] answer = new int[n];

        Map<Character, Integer> teams = new HashMap<>();
        List<Student> list = new ArrayList<>();

        for (int i = 0; i < students.length; i++) {
            int attack = Integer.parseInt(students[i].split(" ")[1]);
            char team = students[i].split(" ")[0].toCharArray()[0];
            list.add(new Student(i, attack, team));
        }

        list.sort((st1, st2) -> st1.attack == st2.attack ? st1.team - st2.team : st1.attack - st2.attack);

        int prev = 0, totalAttack = 0;
        for (int i = 0; i < n; i++) {
            while (prev < n) {
                if (prev >= i || list.get(prev).attack == list.get(i).attack) break;

                totalAttack += list.get(prev).attack;
                teams.put(list.get(prev).team, teams.getOrDefault(list.get(prev).team, 0) + list.get(prev).attack);
                prev++;
            }
            answer[list.get(i).idx] = totalAttack - teams.getOrDefault(list.get(i).team, 0);
        }

        return answer;
    }

    public static void main(String[] args){
        전투_게임 T = new 전투_게임();
        System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }
}