import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(o -> o[0]));

        int answer = 0;
        int baseEnd = -40000;
        for (int[] route : routes) {
            int curStart = route[0];
            int curEnd = route[1];

            if (curStart <= baseEnd) {
                baseEnd = Math.min(baseEnd, curEnd);
            } else {
                answer++;
                baseEnd = curEnd;
            }
        }
        return answer;
    }
}