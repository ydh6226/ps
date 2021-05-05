import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int[] tops = new int[n];

        for (int i = 0; i < n; i++) {
            tops[i] = Integer.parseInt(split[i]);
        }

        int[] result = new int[n];
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{200000000, 0});

        for (int i = 0; i < n; i++) {
            while (stack.peek()[0] < tops[i]) {
                stack.pop();
            }
            result[i] = stack.peek()[1];
            stack.push(new int[]{tops[i], i + 1});
        }
        for (int i : result) {
            bw.write(i + " ");
        }
        bw.flush();
    }
}
