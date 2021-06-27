import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static int pLength;
    private static int first = 1;
    private static int mod = 997;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String p = br.readLine();

        int sLength = s.length();
        pLength = p.length();

        if (sLength < pLength) {
            System.out.println(0);
            return;
        }

        int sHash = getHash(s.substring(0, pLength));
        int pHash = getHash(p);

        if (sHash == pHash && s.substring(0, pLength).equals(p)) {
            System.out.println(1);
            return;
        }

        for (int i = 0; i < pLength -1; i++) {
            first = (first * 2) % mod;
        }

        for (int i = 0; i + pLength <= s.length(); i++) {
            if (sHash == pHash && p.equals(s.substring(i, i + pLength))) {
                System.out.println(1);
                return;
            }
            if (i + pLength < sLength) {
                sHash = getNextHash(sHash, s.charAt(i), s.charAt(i + pLength));
            }
        }
        System.out.println(0);
    }

    private static int getNextHash(int hash, char beforeChar, char nextChar) {
        int result = hash - (beforeChar * first % mod);
        result = (result + mod) % mod;
        result = result * 2 % mod;
        result = (result + nextChar) % mod;
        return result;
    }

    private static int getHash(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            result = (result * 2 + str.charAt(i)) % mod;
        }
        return result;
    }
}
