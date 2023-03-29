import java.util.*;

class 회장선거 {
    public String solution(String[] votes, int k){
        String answer = " ";
        Map<String, ArrayList<String>> presVote = new HashMap<>();
        Map<String, Integer> presentMap = new HashMap<>();
        Set<String> presSet = new HashSet<>();

        for (String s : votes) {
            String pres = s.split(" ")[1];
            String voter = s.split(" ")[0];

            presVote.putIfAbsent(pres, new ArrayList<>());
            presVote.get(pres).add(voter);
            presSet.add(pres);
        }

        for (String pres : presSet) {
            if (presVote.get(pres).size() < k) continue;
            for (String voter : presVote.get(pres))
                presentMap.put(voter, presentMap.getOrDefault(voter, 0) + 1);
        }

        int max = 0;
        for (Map.Entry<String, Integer> entry : presentMap.entrySet()) {
            if (entry.getValue() == max)
                answer = entry.getKey().compareTo(answer) < 0 ? entry.getKey() : answer;
            if (entry.getValue() > max) {
                answer = entry.getKey();
                max = entry.getValue();
            }
        }
        return answer;
    }

    public static void main(String[] args){
        회장선거 T = new 회장선거();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}