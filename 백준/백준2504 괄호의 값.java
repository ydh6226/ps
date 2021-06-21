import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] inputs = br.readLine().toCharArray();

        boolean fail = false;
        int result = 0;
        Stack<Character> stack = new Stack<>();

        int times = 1;

        for (int i = 0; i < inputs.length; i++) {
            char bracket = inputs[i];
            if (bracket == '(') {
                times *= 2;
                stack.push(bracket);
            }
            else if (bracket == '[') {
                times *= 3;
                stack.push(bracket);
            }
            else if (bracket == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    if (inputs[i - 1] == '(') {
                        result += times;
                    }
                    stack.pop();
                    times = times / 2;
                } else {
                    fail = true;
                    break;
                }
            } else if (bracket == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    if (inputs[i - 1] == '[') {
                        result += times;
                    }
                    stack.pop();
                    times = times / 3;
                } else {
                    fail = true;
                    break;
                }
            }
        }

        if (!stack.isEmpty() || fail) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}
