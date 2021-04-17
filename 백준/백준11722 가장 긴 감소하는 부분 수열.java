import java.io.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] number = new int[n];
        int[] dp = new int[n];

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            number[i] =  Integer.parseInt(split[i]);
        }

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (number[i] < number[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;
        for (int x : dp) {
            max = Math.max(x, max);
        }
        System.out.println(max);
    }
}
