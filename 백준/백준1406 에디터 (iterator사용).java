import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Character> answer = new LinkedList<>();

        String inputString = br.readLine();
        for (int i = 0; i < inputString.length(); i++) {
            answer.add(inputString.charAt(i));
        }

        ListIterator<Character> iterator = answer.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String cmdString = br.readLine();
            char cmd = cmdString.charAt(0);
            if (cmd == 'L' && iterator.hasPrevious()) {
                iterator.previous();
            } else if (cmd == 'D' && iterator.hasNext()) {
                iterator.next();
            } else if (cmd == 'B' && iterator.hasPrevious()) {
                iterator.previous();
                iterator.remove();
            } else if (cmd == 'P') {
                iterator.add(cmdString.charAt(2));
            }
        }

        for (Character character : answer) {
            bw.write(character);
        }
        bw.flush();
    }
}
