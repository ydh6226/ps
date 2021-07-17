import java.io.*;

public class Main {
    private static char[] answer;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String t = br.readLine();
        String p = br.readLine();
        answer = new char[t.length()];
        char lastChar = p.charAt(p.length() - 1);
        int idx = -1;
        for (int i = 0; i < t.length(); i++) {
            char tChar = t.charAt(i);
            answer[++idx] = tChar;

            if (tChar == lastChar && match(p, idx)) {
                idx -= p.length();
            }
        }

        if (idx == -1) {
            System.out.println("FRULA");
            return;
        }
        System.out.println(String.valueOf(answer, 0 , idx + 1));
    }

    private static boolean match(String p, int idx) {
        int pLen = p.length();
        if (idx < pLen - 1) {
            return false;
        }

        for (int i = 0; i < p.length(); i++) {
            if (answer[idx - i] != p.charAt(pLen - i - 1)) {
                return false;
            }
        }
        return true;
    }
}