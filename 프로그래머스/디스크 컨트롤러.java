import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(i -> i[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));

        int size = jobs.length;
        int time = 0;
        int count = 0;
        int answer = 0;
        while (count < size || !pq.isEmpty()) {
            while (count < size && time >= jobs[count][0]) {
                pq.add(jobs[count++]);
            }

            if (pq.isEmpty()) {
                time = jobs[count][0];
                continue;
            }

            int[] job = pq.poll();
            time += job[1];
            answer += time - job[0];
        }

        return answer / size;
    }
}