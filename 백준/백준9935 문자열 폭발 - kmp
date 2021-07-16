import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String t = br.readLine();
        String p = br.readLine();
        System.out.println(kmp(t, p));
    }

    private static String kmp(String t, String p) {
        Stack<Character> front = new Stack<>();
        Stack<Character> back = new Stack<>();
        for (int i = t.length() - 1; i >= 0; i--) {
            back.push(t.charAt(i));
        }

        int[] pi = getPi(p);
        int j = 0;
        while (!back.isEmpty()) {
            char tChar = back.pop();
            front.push(tChar);

            while (j > 0 && tChar != p.charAt(j)) {
                j = pi[j - 1];
            }

            if (tChar == p.charAt(j)) {
                if (j == p.length() - 1) {
                    undo(front, back, p.length());
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        StringBuilder sb = new StringBuilder(1000000);
        for (Character c : front) {
            sb.append(c);
        }
        if (sb.length() == 0) {
            return "FRULA";
        }
        return sb.toString();
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

    private static void undo(Stack<Character> front, Stack<Character> back, int pLength) {
        for (int i = 0; i < pLength; i++) {
            front.pop();
        }

        for (int i = 0; i < pLength - 1; i++) {
            if (front.isEmpty()) {
                break;
            }
            back.push(front.pop());
        }
    }
}
