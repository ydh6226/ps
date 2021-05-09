import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    private int[] parents;
    private int[] answer;
    Map<String, Integer> personMap;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        parents = new int[enroll.length];
        answer = new int[enroll.length];
        personMap = new HashMap<>();

        personMap.put("-", -1);
        for (int i = 0; i < enroll.length; i++) {
            personMap.put(enroll[i], i);
        }

        for (int i = 0; i < referral.length; i++) {
            parents[personMap.get(enroll[i])] = personMap.get(referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            Integer id = personMap.get(seller[i]);
            int cost = amount[i] * 100;
            sell(id, cost);
        }
        return answer;
    }

    private void sell(int id, int cost) {
        if (id == -1 || cost == 0) {
            return;
        }

        int moneyForParent = cost / 10;
        int moneyForMe = cost - moneyForParent;

        answer[id] += moneyForMe;
        sell(parents[id], moneyForParent);
    }
}