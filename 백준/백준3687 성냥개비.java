import java.io.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] number = {0, 0, 1, 7 ,4 ,2 ,0, 8};
        long[] dp = new long[101];
        System.arraycopy(number, 0, dp, 0, number.length);
        dp[6] = 6;
        dp[8] = 10;

        for (int i = 9; i <= 100 ; i++) {
            dp[i] = dp[i - 2] * 10 + number[2];
            for (int j = 3; j <= 7 ; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] * 10 + number[j]);
            }
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int x = n / 2;
            StringBuilder sb = new StringBuilder(50);
            for (int j = 0; j < x ; j++) {
                sb.append(1);
            }

            if (n % 2 == 1) {
                sb.setCharAt(0, '7');
            }
            bw.write(dp[n] + " " + sb.toString() + "\n");
        }
        bw.flush();
    }
}
