import java.io.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = 1002;
        int[] dp = new int[size];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < size; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        int n = Integer.parseInt(br.readLine());
        System.out.println(dp[n]);
    }
}
