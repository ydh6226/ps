import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String t = br.readLine();
        String p = br.readLine();

        bw.write(kmp(t, p) + "\n");
        for (Integer x : answer) {
            bw.write(x + " ");
        }
        bw.flush();
    }

    private static int kmp(String t, String p) {
        int count = 0;
        int[] pi = getPi(p);
        int j = 0;

        for (int i = 0; i < t.length(); i++) {
            while (j > 0 && t.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }
            if (t.charAt(i) == p.charAt(j)) {
                if (j == p.length() - 1) {
                    count++;
                    answer.add(i - j + 1); //zero index 이면 i - j
                    j = pi[j];
                } else {
                    ++j;
                }
            }
        }
        return count;
    }


    private static int[] getPi(String p) {
        int[] pi = new int[p.length()];
        int j = 0;

        for (int i = 1; i < p.length(); i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }
            if (p.charAt(i) == p.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }
}
