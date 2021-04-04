import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        for (String key : completion) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (String key : participant) {
            if (!map.containsKey(key)) {
                return key;
            }

            int count = map.get(key);

            if (count == 1) {
                map.remove(key);
            } else {
                map.put(key, count - 1);
            }
        }
        return answer;
    }
}