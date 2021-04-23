import java.io.*;
import java.util.*;

public class Main {
    private static int[] root;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int v = Integer.parseInt(inputs[0]);
        int e = Integer.parseInt(inputs[1]);

        root = new int[v + 1];
        List<int[]> graph = new ArrayList<>();

        for (int i=1; i<=v; i++){
            root[i] = i;
        }

        for (int i=0; i<e; i++) {
            String[] split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            int cost = Integer.parseInt(split[2]);

            graph.add(new int[]{a, b, cost});
        }
        graph.sort(Comparator.comparingInt(i -> i[2]));

        int answer = 0;
        for(int[] array : graph) {
            int a = array[0];
            int b = array[1];
            int cost = array[2];

            if (find(a) != find(b)) {
                union(a, b);
                answer += cost;
            }
        }
        bw.write(answer + "");
        bw.flush();
    }

    private static int find(int x){
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    private static void union(int x, int y){
        int a = find(x);
        int b = find(y);
        root[a] = root[b];
    }
}