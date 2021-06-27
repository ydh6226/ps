import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    private static int result = 0;
    private static int n = 0;
    private static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //선언
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                swap(i, j, i, j + 1);
                check();
                swap(i, j, i, j + 1);

                swap(j, i, j+1, i);
                check();
                swap(j, i, j+1, i);
            }
        }

        System.out.println(result);
    }

    private static void check() {
        for (int i = 0; i < n; i++) {
            int count = 1;
            char c = map[i][0];
            for (int j = 1; j < n; j++) {
                if (map[i][j] == c) {
                    count++;
                } else {
                    c = map[i][j];
                    count = 1;
                }
                result = Math.max(result, count);
            }
        }

        for (int i = 0; i < n; i++) {
            int count = 1;
            char c = map[0][i];
            for (int j = 1; j < n; j++) {
                if (map[j][i] == c) {
                    count++;
                } else {
                    c = map[j][i];
                    count = 1;
                }
                result = Math.max(result, count);
            }
        }
    }

    private static void swap(int i1, int j1, int i2, int j2) {
        char tmp = map[i1][j1];
        map[i1][j1] = map[i2][j2];
        map[i2][j2] = tmp;
    }
}
