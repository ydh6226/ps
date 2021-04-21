import java.io.*;
import java.util.*;


class Main {
    private static boolean[] visit;
    private static int[] parentList;
    private static final Map<Integer, List<Integer>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        visit = new boolean[n + 1];
        parentList = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String[] numberInput = br.readLine().split(" ");
            int a = Integer.parseInt(numberInput[0]);
            int b = Integer.parseInt(numberInput[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        findChild(1);
        for (int i = 2; i < parentList.length; i++) {
            bw.write(parentList[i] + "\n");
        }
        bw.flush();
    }

    private static void findChild(int parent) {
        visit[parent] = true;

        List<Integer> children = graph.get(parent);
        for (Integer child : children) {
            if (!visit[child]) {
                parentList[child] = parent;
                findChild(child);
            }
        }
    }
}
