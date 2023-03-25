import java.util.*;

class Solution {

    Map<String,List<Integer>> infoMap = new HashMap<>();
    String[] in;

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for (String infoSentence : info) {
            in = infoSentence.split(" ");
            BT("", 0);
        }

        for (String key : infoMap.keySet())
            Collections.sort(infoMap.get(key));

        for (int i = 0; i < query.length; i++) {
            String[] q = query[i].replaceAll(" and ", "").split(" ");
            answer[i] = infoMap.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
        }
        return answer;
    }

    void BT(String s, int k) {
        if (k == 4) {
            if (!infoMap.containsKey(s))
                infoMap.put(s, new ArrayList<>());
            infoMap.get(s).add(Integer.parseInt(in[k]));
            return;
        }
        BT(s + "-", k + 1);
        BT(s + in[k], k + 1);
    }

    int binarySearch(String key, int score) {
        List<Integer> list = infoMap.get(key);
        int st = 0, en = list.size() - 1;

        while (st <= en) {
            int mid = (st + en) / 2;

            if (score > list.get(mid))
                st = mid + 1;
            else
                en = mid - 1;
        }
        return list.size() - st;
    }
}