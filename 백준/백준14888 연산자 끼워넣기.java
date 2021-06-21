import java.io.*;

public class Main {
    private static int n;
    private static int[] numbers;
    private static int[] operationCounts;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        String[] valInputs = br.readLine().split(" ");
        numbers = new int[valInputs.length];
        for (int i = 0; i < valInputs.length; i++) {
            numbers[i] = Integer.parseInt(valInputs[i]);
        }

        String[] operationInputs = br.readLine().split(" ");
        operationCounts = new int[operationInputs.length];
        for (int i = 0; i < operationInputs.length; i++) {
            operationCounts[i] = Integer.parseInt(operationInputs[i]);
        }

        dfs(1, numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int idx, int result) {
        if (n == idx) {
            max = Integer.max(max, result);
            min = Integer.min(min, result);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operationCounts[i] > 0) {
                operationCounts[i]--;
                dfs(idx + 1, calculate(i, result, numbers[idx]));
                operationCounts[i]++;
            }
        }
    }

    private static int calculate(int i, int a, int b) {
        int result = 0;
        switch (i) {
            case 0:
                result = a + b;
                break;
            case 1:
                result = a - b;
                break;
            case 2:
                result = a * b;
                break;
            case 3:
                result = a / b;
                break;
        }
        return result;
    }
}
