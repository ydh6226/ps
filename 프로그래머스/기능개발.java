import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int size = progresses.length;
        List<Integer> answer = new ArrayList<>();

        int idx = 0;
        while (idx < size) {
            int progressCount = 0;
            int requiredDay = getRequiredDay(100 - progresses[idx], speeds[idx]);

            while (progresses[idx] + speeds[idx] * requiredDay >= 100) {
                progressCount++;
                if (++idx >= size) {
                    break;
                }
            }
            answer.add(progressCount);
        }
        int[] ans = new int[answer.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = answer.get(i);
        }
        return ans;
    }

    private int getRequiredDay(int remainProgress, int speed) {
        int day = remainProgress / speed;
        if (remainProgress % speed != 0) {
            day++;
        }
        return day;
    }
}