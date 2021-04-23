import java.io.*;
import java.util.*;

public class Main {
    private static final int INF = 200000000;
    private static int n;
    private static Map<Integer, List<int[]>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        int e = Integer.parseInt(inputs[1]);

        for(int i=1; i<=n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int i=0; i<e; i++) {
            String[] nodeInputs = br.readLine().split(" ");
            int a = Integer.parseInt(nodeInputs[0]);
            int b = Integer.parseInt(nodeInputs[1]);
            int v = Integer.parseInt(nodeInputs[2]);

            graph.get(a).add(new int[]{b, v});
            graph.get(b).add(new int[]{a, v});
        }

        String[] pathInputs = br.readLine().split(" ");
        int v1 = Integer.parseInt(pathInputs[0]);
        int v2 = Integer.parseInt(pathInputs[1]);



        int[] a = dijkstra(1, v1, v2);
        int[] b = dijkstra(v1, v2, 0);
        int[] c = dijkstra(n, v1, v2);

        int answer = Math.min(a[0] + b[0] + c[1], a[1] + b[0] + c[0]);
        if (answer >= INF){
            answer = -1;
        }
        System.out.println(answer);
    }

    private static int[] dijkstra(int start, int end, int end2) {
        boolean[] visit = new boolean[n + 1];
        int[] costs = new int[n + 1];

        Arrays.fill(costs, INF);
        costs[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i->i[1]));

        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int node = poll[0];
            int val = poll[1];

            visit[node] = true;

            List<int[]> nodes = graph.get(node);
            for(int[] next : nodes) {
                if (!visit[next[0]] && costs[next[0]] > val + next[1]) {
                    costs[next[0]] = val + next[1];
                    pq.add(new int[]{next[0], costs[next[0]]});
                }
            }
        }

        return new int[]{costs[end], costs[end2]};
    }
}