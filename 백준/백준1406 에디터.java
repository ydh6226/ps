import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> leftOfCursor = new Stack<>();
        Stack<Character> rightOfCursor = new Stack<>();

        String inputString = br.readLine();
        for (int i = 0; i < inputString.length(); i++) {
            leftOfCursor.push(inputString.charAt(i));
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String cmdString = br.readLine();
            char cmd = cmdString.charAt(0);
            if (cmd == 'L' && !leftOfCursor.isEmpty()) {
                rightOfCursor.push(leftOfCursor.pop());
            } else if (cmd == 'D' && !rightOfCursor.isEmpty()) {
                leftOfCursor.push(rightOfCursor.pop());
            } else if (cmd == 'B' && !leftOfCursor.isEmpty()) {
                leftOfCursor.pop();
            } else if (cmd == 'P') {
                leftOfCursor.push(cmdString.charAt(2));
            }
        }

        StringBuilder sb = new StringBuilder(leftOfCursor.size() + rightOfCursor.size());
        for (Character character : leftOfCursor) {
            sb.append(character);
        }

        while (!rightOfCursor.isEmpty()) {
            sb.append(rightOfCursor.pop());
        }
        System.out.println(sb.toString());
    }
}
