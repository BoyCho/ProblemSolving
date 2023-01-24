import java.util.ArrayList;
import java.util.List;

public class Solution {

    static List<List<Integer>> combList;
    static List<List<Integer>> candKeyList;
    static boolean[] vis;
    static int attribute, tuple;

    public int solution(String[][] relation) {
        tuple = relation.length;
        attribute = relation[0].length;
        combList = new ArrayList<>();
        candKeyList = new ArrayList<>();
        vis = new boolean[attribute];

        for (int i = 1; i <= attribute; i++)
            combination(0, i);

        for (List<Integer> comb : combList) {
            // 최소성 검사
            if(checkMinimality(comb)) continue;
            // 유일성 검사
            checkUniqueness(relation, comb);
        }
        return candKeyList.size();
    }

    private boolean checkMinimality(List<Integer> comb) {
        for (List<Integer> candKey : candKeyList) {
            int cnt = 0;
            for (int index : candKey) {
                if (comb.contains(index))
                    cnt++;
            }
            if (cnt == candKey.size())
                return true;
        }
        return false;
    }

    private void checkUniqueness(String[][] relation, List<Integer> comb) {
        for (int x = 0; x < tuple; x++) {
            for (int y = 0; y < tuple; y++) {
                if (x == y) continue;
                int cnt = 0;

                for (int index: comb) {
                    if (relation[x][index].equals(relation[y][index]))
                        cnt++;
                    if (cnt == comb.size())
                        return;
                }
            }
        }
        candKeyList.add(comb);
    }

    void combination(int st, int r) {
        if (r == 0) {
            List<Integer> a = new ArrayList<>();
            for (int i = 0; i < attribute; i++) {
                if (vis[i]) a.add(i);
            }
            combList.add(a);
            return;
        }
        for (int i = st; i < attribute; i++) {
            vis[i] = true;
            combination(i + 1, r - 1);
            vis[i] = false;
        }
    }
}
