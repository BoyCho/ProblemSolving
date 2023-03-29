import java.util.*;
class 문서도난 {
    public String[] solution(String[] reports, String times){
        String stTime = times.split(" ")[0];
        String enTime = times.split(" ")[1];

        List<String> ansTime = new ArrayList<>();
        HashMap<String, String> timeToName = new HashMap<>();

        for (String r : reports) {
            String name = r.split(" ")[0];
            String time = r.split(" ")[1];

            if (time.compareTo(stTime) < 0 || time.compareTo(enTime) > 0) continue;
            ansTime.add(time);
            timeToName.put(time, name);
        }
        ansTime.sort(String::compareTo);

        String[] answer = new String[ansTime.size()];
        for (int i = 0; i < answer.length; i++)
            answer[i] = timeToName.get(ansTime.get(i));

        return answer;
    }

    public static void main(String[] args){
        문서도난 T = new 문서도난();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}