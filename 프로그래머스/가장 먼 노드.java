import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        boolean[] visit = new boolean[n + 1];

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i + 1, new ArrayList<>());
        }

        for (int[] ints : edge) {
            graph.get(ints[0]).add(ints[1]);
            graph.get(ints[1]).add(ints[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        visit[1] = true;
        queue.add(1);

        int answer = 0;
        while (!queue.isEmpty()) {
            int count  = queue.size();
            answer = count;

            while (--count >= 0) {
                Integer poll = queue.poll();
                List<Integer> nodes = graph.get(poll);

                for (Integer node : nodes) {
                    if (visit[node]) {
                        continue;
                    }
                    visit[node] = true;
                    queue.add(node);
                }

            }
        }
        return answer;
    }
}