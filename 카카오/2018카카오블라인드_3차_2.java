import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(String.valueOf(c), (c - 'A') + 1);
        }

        int idx = 0, value = map.size();
        while (idx < msg.length()) {
            String sub = "";
            sub += msg.charAt(idx);

            boolean isEnd = false;
            while (map.containsKey(sub)) {
                idx++;
                if (idx < msg.length()) {
                    sub += msg.charAt(idx);
                    continue;
                }
                isEnd = true;
                break;
            }

            if (isEnd) {
                answer.add(map.get(sub));
            } else {
                map.put(sub, ++value);
                answer.add(map.get(sub.substring(0, sub.length() - 1)));
            }
        }

        int[] ans = new int[answer.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = answer.get(i);
        }

        return ans;
    }
}