import java.io.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] step = new int[301];
        int[] dp = new int[301];

        for (int i = 1; i <= n; i++) {
            step[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = step[1];
        dp[2] = step[1] + step[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(step[i] + step[i - 1] + dp[i - 3], step[i] + dp[i - 2]);
        }
        System.out.println(dp[n]);
    }
}
