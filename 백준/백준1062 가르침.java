import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<String> words = new ArrayList<>();
    private static int k;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        k = Integer.parseInt(inputs[1]);

        if (k < 5) {
            System.out.println("0");
            return;
        }

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            words.add(word.substring(4, word.length() - 4));
        }

        int use = 1 + (1 << 2) + (1 << 8) + (1 << 13) + (1 << 19);

        dfs(use, 5, 0);
        System.out.println(result);

    }

    private static void dfs(int use, int count, int idx) {
        if (count == k) {
            int tmp = 0;
            for (int i = 0; i < words.size(); i++) {
                boolean possible = true;
                String word = words.get(i);
                for (int j = 0; j < word.length(); j++) {
                    if ((use & (1 << (word.charAt(j) - 'a'))) == 0) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    tmp++;
                }
            }
            result = Math.max(result, tmp);
            return;
        }

        for (int i = idx; i < 26; i++) {
            if ((use & (1 << i)) > 0) {
                continue;
            }
            dfs((use | (1 << i)), count + 1, i + 1);
        }
    }
}
