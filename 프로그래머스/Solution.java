import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] dress = new int[n + 2];
        Arrays.fill(dress, 1);

        for (int x : reserve) {
            dress[x]++;
        }

        for (int x : lost) {
            dress[x]--;
        }

        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            if (dress[i] >= 1) {
                answer++;
                continue;
            }

            if (dress[i - 1] > 1) {
                dress[i - 1]--;
                answer++;
                continue;
            }

            if (dress[i + 1] > 1) {
                dress[i + 1]--;
                answer++;
            }
        }
        return answer;
    }
}