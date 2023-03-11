
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        int[] dx = {1,0,-1,0,1,1,-1,-1,0,2,0,-2};
        int[] dy = {0,1,0,-1,-1,1,1,-1,-2,0,2,0};

        for (int n = 0; n < 5; n++) {
            boolean flag = false;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (places[n][i].charAt(j) != 'P') continue;

                    for (int k = 0; k < 12; k++) {
                        int nx = j + dx[k];
                        int ny = i + dy[k];

                        if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                        if (places[n][ny].charAt(nx) != 'P') continue;
                        
                        if (k < 4) flag = true;
                        
                        else if (k < 8) {
                            if (places[n][i+dy[k]].charAt(j) != 'X' || places[n][i].charAt(j+dx[k]) != 'X')
                                flag = true;
                        }
                        else {
                            if (dy[k]!=0 && places[n][i+dy[k]/2].charAt(j) != 'X')
                                flag = true;
                            if (dx[k]!=0 && places[n][i].charAt(j+dx[k]/2) != 'X')
                                flag = true;
                        }
                        if (flag) break;
                    }
                    if (flag) break;
                }
                if (flag) break;
            }
            answer[n] = flag ? 0 : 1;
        }
        return answer;
    }
}