import java.util.*;
class 교육_과정 {
    public String[] solution(String[] subjects, String[] course){
        int n = subjects.length;
        Map<String, Integer> NameToIdx = new HashMap<>();
        Map<Integer, HashSet<Integer>> degree = new HashMap<>();

        for (int i = 0; i < n; i++) {
            NameToIdx.put(subjects[i], i);
        }

        int[] inDegree = new int[n];
        for (String s : course) {
            int n1 = NameToIdx.get(s.split(" ")[0]);
            int n2 = NameToIdx.get(s.split(" ")[1]);

            degree.putIfAbsent(n2, new HashSet<>());
            degree.get(n2).add(n1);
            inDegree[n1]++;
        }

        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++)
            if (inDegree[i] == 0) Q.add(i);

        List<Integer> ans = new ArrayList<>();
        while (!Q.isEmpty()) {
            int cur = Q.poll();
            ans.add(cur);

            if (degree.get(cur) == null) continue;

            for (int x : degree.get(cur)) {
                if (--inDegree[x] == 0)
                    Q.add(x);
            }
        }
        String[] answer = new String[ans.size()];
        for (int i = 0; i < answer.length; i++) answer[i] = subjects[ans.get(i)];
        return answer;
    }

    public static void main(String[] args){
        교육_과정 T = new 교육_과정();
        System.out.println(Arrays.toString(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"})));
    }
}