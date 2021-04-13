import java.nio.file.Path;
import java.util.Arrays;

class Solution {
    private int idx = 0;
    private int len;

    public int solution(String name) {
        len = name.length();
        char[] chars = new char[len];
        Arrays.fill(chars, 'A');
        String source = String.valueOf(chars);

        int count = len;
        boolean[] same = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (name.charAt(i) == source.charAt(i)) {
                same[i] = true;
                count--;
            }
        }

        int answer = 0;
        while (true) {
            if (!same[idx]) {
                answer += compareY(name.charAt(idx), source.charAt(idx));
                same[idx] = true;
                count--;
            }
            if (count == 0) {
                break;
            }
            answer += compareX(same);
        }
        return answer;
    }

    public int compareX(boolean[] same) {
        int left = 0;
        int right = 0;

        for (int i = 1; i < len; i++) {
            int tmpIdx = idx - i;
            if (tmpIdx < 0) {
                tmpIdx = len + tmpIdx;
            }
            if (!same[tmpIdx]) {
                left = i;
                break;
            }
        }

        for (int i = 1; i < len; i++) {
            if (!same[(idx + i) % len]) {
                right = i;
                break;
            }
        }

        if (left <= right) {
            idx = (idx + right) % len;
        } else {
            idx = idx - left;
            if (idx < 0) {
                idx = len + idx;
            }
        }
        return Math.min(left, right);
    }

    private int compareY(char target, char source) {
        int up = target - source;
        int down = 26 - up;
        return Math.min(up, down);
    }
}