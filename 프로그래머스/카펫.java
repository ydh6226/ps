import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int all = brown + yellow;

        List<Integer> heights = getHeights(all);
        for (int h : heights) {
            int w = all / h;

            int predictedBrown = (h + w) * 2 - 4;
            if (predictedBrown == brown) {
                answer[0] = w;
                answer[1] = h;
            }
        }
        return answer;
    }

    private List<Integer> getHeights(int all) {
        List<Integer> heights = new ArrayList<>();
        for (int i = 1; i * i <= all ; i++) {
            if (all % i == 0) {
                heights.add(i);
            }
        }
        return heights;
    }
}