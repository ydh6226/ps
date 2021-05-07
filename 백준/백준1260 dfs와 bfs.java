import java.io.*;
import java.util.*;

public class Main {
    private static boolean[] visit;
    private static Map<Integer, List<Integer>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int v = Integer.parseInt(split[2]);

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        visit = new boolean[n + 1];
        visit[v] = true;

        dfs(bw, v);
        bw.newLine();

        Arrays.fill(visit, false);
        visit[v] = true;
        bfs(bw, v);

        bw.flush();
    }

    private static void dfs(BufferedWriter bw, int node) throws IOException {
        bw.write(node + " ");

        for (Integer next : graph.get(node)) {
            if (!visit[next]) {
                visit[next] = true;
                dfs(bw, next);
            }
        }
    }

    private static void bfs(BufferedWriter bw, int node) throws IOException {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            bw.write(current + " ");

            for (Integer next : graph.get(current)) {
                if (!visit[next]) {
                    visit[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
