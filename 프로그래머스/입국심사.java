import java.nio.file.Path;
import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long asnwer = 0;
        long left = 0;
        long right = times[times.length - 1] * n;
        while (left <= right) {
            long mid = (left + right) / 2;
            int pass = 0;

            for (int i = 0; i < times.length; i++) {
                pass += mid / times[i];
            }

            if (pass >= n) {
                right = mid - 1;
                asnwer = mid;
            } else {
                left = mid + 1;
            }
        }
        return asnwer;
    }
}