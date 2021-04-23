import java.io.*;
import java.util.*;

public class Main {
    private static int[] root;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        String[] numInputs = br.readLine().split(" ");
        int[] numbers = new int[n];
        for (int i=0; i<n; i++) {
            numbers[i] = Integer.parseInt(numInputs[i]);
        }

        int answer = 0;
        int sum = numbers[0];
        int left = 0;
        int right = 0;
        while(true) {
            if (sum == m) {
                answer++;
            }

            if (sum < m) {
                if (right + 1 == n) {
                    break;
                }
                sum += numbers[++right];
            } else {
                sum -= numbers[left++];
            }
        }
        System.out.println(answer);
    }
}