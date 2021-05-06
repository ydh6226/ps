import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    Map<Long, Long> root = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        for (int i = 0; i < room_number.length; i++) {
            answer[i] = getRoot(room_number[i]);
        }
        return answer;
    }

    private long getRoot(long x) {
        if (!root.containsKey(x)) {
            root.put(x, x + 1);
            return x;
        }

        root.put(x, getRoot(root.get(x)));
        return root.get(x);
    }
}