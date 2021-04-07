import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] clone = array.clone();

            Arrays.sort(clone, commands[i][0] - 1, commands[i][1]);
            answer[i] = clone[commands[i][0] + commands[i][2] - 2];
        }
        return answer;
    }
}