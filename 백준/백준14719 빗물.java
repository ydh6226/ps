import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int h = Integer.parseInt(inputs[0]);
        int w = Integer.parseInt(inputs[1]);

        int[] blockCountPerLine = new int[w];
        inputs = br.readLine().split(" ");

        for (int i = 0; i < inputs.length; i++) {
            blockCountPerLine[i] = Integer.parseInt(inputs[i]);
        }

        int result = 0;
        for (int i = 1; i < w - 1; i++) {
            int left = 0;
            int right = 0;

            for (int j = 0; j < i; j++) {
                left = Math.max(left, blockCountPerLine[j]);
            }

            for (int j = i + 1; j < w; j++) {
                right = Math.max(right, blockCountPerLine[j]);
            }

            int val = Math.min(left, right) - blockCountPerLine[i];
            if (val > 0) {
                result += val;
            }
        }
        System.out.println(result);
    }
}
