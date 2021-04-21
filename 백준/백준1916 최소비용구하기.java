import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        Map<Integer, List<int[]>> graph = new HashMap<>();
        boolean[] visit = new boolean[n + 1];
        int[] cost = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            cost[i] = 111111111;
        }

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            String[] split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            int v = Integer.parseInt(split[2]);

            graph.get(a).add(new int[]{b, v});
        }

        String[] split = br.readLine().split(" ");
        int start = Integer.parseInt(split[0]);
        int end = Integer.parseInt(split[1]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
        pq.add(new int[]{start, 0});
        cost[start] = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int node = poll[0];
            int val = poll[1];
            visit[node] = true;

            List<int[]> nextNodes = graph.get(node);
            for (int[] nextNode : nextNodes) {
                if (cost[nextNode[0]] > nextNode[1] + val && !visit[nextNode[0]]) {
                    cost[nextNode[0]] = nextNode[1] + val;
                    pq.add(new int[]{nextNode[0], cost[nextNode[0]]});
                }
            }
        }
        System.out.println(cost[end]);
    }
}
