import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i : scoville) {
            pq.add((long) i);
        }

        int count = 0;
        while (pq.size() >= 2) {
            Long first = pq.poll();

            if (first >= (long) K) {
                break;
            }

            Long second = pq.poll();
            pq.add(first + second * 2);
            count++;
        }

        if (pq.peek() < K) {
            return -1;
        }

        return count;
    }
}