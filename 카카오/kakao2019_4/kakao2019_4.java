import java.util.*;

class Solution {
    static class Page{
        private int index;
        private String url;
        private double baseScore;
        private double linkScore;
        private double linkScoreForOther;
        private final List<String> linkList;

        Page(int index){
            this.index = index;
            this.baseScore = 0.0;
            this.linkScore = 0.0;
            linkList = new ArrayList<>();
        }

        public void setLinkScoreForOther() {
            this.linkScoreForOther = baseScore / linkList.size();
        }
    }

    public int solution(String word, String[] pages) {
        int answer = 0;
        Page[] pageList = new Page[pages.length];
        Map<String, Integer> urlMap = new HashMap<>();

        // index 기준 파싱
        int idx = 0;
        for (String page : pages) {
            pageList[idx] = new Page(idx);

            // 본인 url get
            String url = page.split("<meta property=\"og:url\" content=\"",2)[1];
            url = url.split("\"",2)[0];
            pageList[idx].url = url;
            urlMap.put(url, idx);

            // 외부 링크 url get
            String[] splited = page.split("<a href=\"");
            for (String s: splited) {
                if (s.startsWith("https"))
                    pageList[idx].linkList.add(s.split("\"",2)[0]);
            }

            // 기본 점수 get
            splited = page.split("<body>|</body>");
            String text = splited[1];

            splited = text.split("\\W|\\n|\\d");
            for (String s : splited) {
                if (s.equalsIgnoreCase(word))
                    pageList[idx].baseScore++;
            }

            // 링크 점수 forOther get
            pageList[idx++].setLinkScoreForOther();
        }

        // 링크 점수 get : 입력이 다 끝난 후에 확인이 가능한 과정
        for (Page page : pageList) {
            for (String s : page.linkList) {
                if (urlMap.get(s) != null)  // pages 에 존재하는 url 이라면
                    pageList[urlMap.get(s)].linkScore += page.linkScoreForOther;
            }
        }

        // 매칭 점수 비교
        double max = 0.0;
        for (Page page : pageList) {
            double matchingScore = page.baseScore + page.linkScore;

            if (max < matchingScore) {  // 매칭 점수가 같다면, 제일 작은 Index
                max = matchingScore;
                answer = page.index;
            }
        }
        return answer;
    }
}