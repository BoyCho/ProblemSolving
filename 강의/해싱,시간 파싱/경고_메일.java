import java.util.*;
class 경고_메일 {
    public String[] solution(String[] reports, int t){
        HashMap<String, String> nT = new HashMap<>();
        HashMap<String, Integer> nTotalT = new HashMap<>();
        HashSet<String> warning = new HashSet<>();

        for (String s : reports) {
            String[] report = s.split(" ");
            String name = report[0];
            String time = report[1];
            String state = report[2];

            if (state.equals("in"))
                nT.put(name, time);
            else {
                int outTime = getTime(time);
                int inTime = getTime(nT.get(name));
                nTotalT.put(name, nTotalT.getOrDefault(name, 0) + outTime - inTime);

                if (nTotalT.get(name) > t) warning.add(name);
            }
        }
        List<String> ans = new ArrayList<>(warning);
        ans.sort(String::compareTo);

        String[] answer = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            answer[i] = ans.get(i);
        return answer;
    }

    int getTime(String time) {
        int h = Integer.parseInt(time.split(":")[0]);
        int m = Integer.parseInt(time.split(":")[1]);
        return h * 60 + m;
    }

    public static void main(String[] args){
        경고_메일 T = new 경고_메일();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}