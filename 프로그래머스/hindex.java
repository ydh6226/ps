import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int size = citations.length;
        Arrays.sort(citations);

        int answer = 0;
        for (int i = size; i > 0; i--) {
            if (citations[size - i] >= i) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}