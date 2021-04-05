import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int size = truck_weights.length;
        int notArriveCount = size;
        int currentWeight = 0;
        Queue<Integer> q = new LinkedList<>();

        int time;
        int idx = 0;
        for (time = 1; notArriveCount > 0; time++) {
            if (!q.isEmpty() && q.peek().equals(time)) {
                q.poll();
                currentWeight -= truck_weights[size - notArriveCount--];
            }

            if (idx < size && currentWeight + truck_weights[idx] <= weight) {
                q.add(time + bridge_length);
                currentWeight += truck_weights[idx];
                idx++;
            }
        }
        return time - 1;
    }
}