import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    
    ArrayList<Integer> cKeyList;
    int n, m;

    public int solution(String[][] relation) {

        cKeyList = new ArrayList<>();   // 후보키 리스트
        m = relation[0].length;         // m개의 컬럼
        n = relation.length;            // n개의 데이터
        
        // 완전 탐색
        for(int i = 1; i < (1<<m); i++) {
            Set<String> checkUnique = new HashSet<>();
            // n개의 데이터
            for (int j = 0; j < n; j++) {
                StringBuilder sb = new StringBuilder();
                // m개의 컬럼
                for (int k = 0; k < m; k++) {
                    // 모든 경우의 수 & 해당 컬럼 조합 : 부분 집합 선택
                    if ((i & (1 << k)) > 0)
                        sb.append(relation[j][k]);
                }
                checkUnique.add(sb.toString());
            }
            // 유일성 확인
            if (checkUnique.size() != n) continue;
            // 최소성 확인
            checkMin(i);
        }
        return cKeyList.size();
    }
    public void checkMin(int i) {
        for (Integer cKey : cKeyList)
            if ((cKey & i) == cKey) return;
        cKeyList.add(i);
    }
}
