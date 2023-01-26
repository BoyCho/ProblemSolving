import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

class Solution {
    static class Page{
        private int index;
        private String url;
        private double baseScore;
        private double matchScore;
        private List<String> linkList;

        Page(int index){
            this.index = index;
            this.baseScore = 0.0;
            this.matchScore = 0.0;
            this.linkList = new ArrayList<>();
        }
    }

    public static int solution(String word, String[] pages) {
        Pattern urlP = Pattern.compile("<meta\\sproperty=\"og:url\"\\scontent=\"(\\S*)\"");
        Pattern linkP = Pattern.compile("<a\\shref=\"(\\S*)\"");
        Pattern wordP = Pattern.compile("\\b" + word.toLowerCase() + "\\b");

        Page[] pageList = new Page[pages.length];
        Map<String, Integer> urlMap = new HashMap<>();

        int idx = 0;
        for (String page : pages) {
            page = page.toLowerCase();
            pageList[idx] = new Page(idx);
            Matcher urlM = urlP.matcher(page);
            Matcher linkM = linkP.matcher(page);

            if (urlM.find()) {
                pageList[idx].url = urlM.group().split("\"")[3];
                urlMap.put(pageList[idx].url, idx);
            }

            while (linkM.find())
                pageList[idx].linkList.add(linkM.group().split("\"")[1]);

            Matcher wordM = wordP.matcher(page.split("<body>|</body>")[1].replaceAll("\\W|\\d", " "));
            while(wordM.find())
                pageList[idx].matchScore = ++pageList[idx].baseScore;
            idx++;
        }

        for (Page page : pageList) {
            for (String linkUrl : page.linkList) {
                if (urlMap.get(linkUrl) != null)
                    pageList[urlMap.get(linkUrl)].matchScore += page.baseScore / page.linkList.size();
            }
        }

        double max = 0.0;
        int answer = 0;

        for (Page page : pageList) {
            System.out.println(page.matchScore);
            if (max < page.matchScore) {
                max = page.matchScore;
                answer = page.index;
            }
        }
        return answer;
    }
}