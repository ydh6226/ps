import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int len;
    boolean[] visit;

    public int solution(String begin, String target, String[] words) {
        len = begin.length();
        visit = new boolean[words.length];

        Queue<String> queue = new LinkedList<>();
        queue.add(begin);

        int answer = -1;
        while (!queue.isEmpty()) {
            int count = queue.size();
            answer++;

            while (--count >= 0) {
                String source = queue.poll();
                if (source.equals(target)) {
                    return answer;
                }

                for (int i = 0; i < words.length; i++) {
                    if (visit[i]) {
                        continue;
                    }

                    if (isMatch(source, words[i])) {
                        visit[i] = true;
                        queue.add(words[i]);
                    }
                }
            }
        }
        return 0;
    }

    boolean isMatch(String source, String target) {
        int count = len;
        for (int i = 0; i < len; i++) {
            if (source.charAt(i) == target.charAt(i)) {
                count--;
            }
        }
        return count == 1;
    }
}