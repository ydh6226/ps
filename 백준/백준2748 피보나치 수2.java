import java.io.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int size = 91;
        long[] dp = new long[size];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < size; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int n = Integer.parseInt(br.readLine());
        bw.write(dp[n] + "\n");
        bw.flush();
    }
}
