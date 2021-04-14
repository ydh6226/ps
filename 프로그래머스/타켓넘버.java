class Solution {
    int T;
    int size;
    int answer = 0;

    public int solution(int[] numbers, int target) {
        T = target;
        size = numbers.length;
        dfs(numbers, 0, 0);
        return answer;
    }

    private void dfs(int[] numbers, int idx, int sum) {
        if (idx == size) {
            if (sum == T) {
                answer++;
            }
            return;
        }

        dfs(numbers, idx + 1, sum + numbers[idx]);
        dfs(numbers, idx + 1, sum - numbers[idx]);
    }
}