import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] correct = new int[4];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i % first.length]){
                correct[1]++;
            }
            if (answers[i] == second[i % second.length]){
                correct[2]++;
            }
            if (answers[i] == third[i % third.length]){
                correct[3]++;
            }
        }

        int max = 0;
        for (int i = 1; i < correct.length; i++) {
            max = Math.max(max, correct[i]);
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i < correct.length; i++) {
            if (max == correct[i]) {
                answer.add(i);
            }
        }

        int[] ans = new int[answer.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = answer.get(i);
        }

        return ans;
    }
}