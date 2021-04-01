class Solution {
    public int solution(int[] stones, int k) {
        int min = Integer.MAX_VALUE, max = 0;
        for (int stone : stones) {
            min = Math.min(min, stone);
            max = Math.max(max, stone);
        }

        int answer = 0;
        int mid = 0;
        while (min <= max) {
            mid = (min + max) / 2;

            if (isPossible(stones, k, mid)) {
                answer = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return mid;
    }

    private boolean isPossible(int[] stones, int k, int num) {
        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] - num < 0) {
                count++;
            } else {
                count = 0;
            }

            if (count == k)
                return false;
        }
        return true;
    }
}