import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int start = 0;
        int end = people.length;

        int answer = 0;
        while (start < end) {
            end--;
            if (start < end && people[end] + people[start] <= limit) {
                start++;
            }
            answer++;
        }
        return answer;
    }
}