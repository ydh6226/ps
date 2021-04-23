import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int x = Integer.parseInt(split[2]);

        int[][] costs = new int[n+1][n+1];
        for(int[] cost : costs) {
            Arrays.fill(cost, 10000000);
        }

        for (int i=1; i<=n; i++) {
            costs[i][i] = 0;
        }

        for (int i=0; i<m; i++) {
            String[] costInput = br.readLine().split(" ");
            int start = Integer.parseInt(costInput[0]);
            int end = Integer.parseInt(costInput[1]);
            int val = Integer.parseInt(costInput[2]);
            costs[start][end] = val;
        }

        for (int mid=1; mid<=n; mid++){
            for (int i=1; i<=n; i++){
                for (int j=1; j<=n; j++){
                    if (costs[i][j] > costs[i][mid] + costs[mid][j]) {
                        costs[i][j] = costs[i][mid] + costs[mid][j];
                    }
                }
            }
        }

        int answer = -1;

        for (int i=1; i<=n; i++) {
            answer = Math.max(answer, costs[i][x] + costs[x][i]);
        }

        bw.write(answer + "");
        bw.flush();
    }
}