import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();

        int count = 0;
        for (String r : record) {
            String[] array = r.split(" ");
            String op = array[0];
            String id = array[1];

            if (!op.equals("Change"))
                count++;

            if (op.equals("Leave"))
                continue;

            String nickname = array[2];
            map.put(id, nickname);
        }

        int idx = 0;
        String[] answer = new String[count];
        for (String r : record) {
            String[] array = r.split(" ");
            String op = array[0];
            String id = array[1];

            if (op.equals("Change")) {
                continue;
            }

            if (op.equals("Enter"))
                answer[idx++] = map.get(id) + "님이 들어왔습니다.";
            else
                answer[idx++] = map.get(id) + "님이 나갔습니다.";
        }
        return answer;
    }
}