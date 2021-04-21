import java.io.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] time = new int[n + 2];
        int[] pay = new int[n + 2];
        int[] dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            String[] inputs = br.readLine().split(" ");
            time[i] = Integer.parseInt(inputs[0]);
            pay[i] = Integer.parseInt(inputs[1]);
        }

        for (int i = 1; i <= n + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i]);

            int nextDay = i + time[i];
            if (nextDay > n + 1) {
                continue;
            }

            dp[nextDay] = Math.max(dp[nextDay], dp[i] + pay[i]);
        }
        System.out.println(dp[n + 1]);
    }
}
