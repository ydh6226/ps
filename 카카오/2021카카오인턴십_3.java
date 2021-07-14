import java.util.LinkedList;
import java.util.Stack;
 
class Solution {
    public String solution(int n, int k, String[] cmd) {
        LinkedList<Integer> stack = new LinkedList<>();
        int size = n;
        int idx = k;
 
        for (String c : cmd) {
            char command = c.charAt(0);
            switch (command) {
                case 'U':
                    idx -= getDistance(c);
                    break;
                case 'D':
                    idx += getDistance(c);
                    break;
                case 'C':
                    stack.push(idx);
                    if (idx == size - 1) {
                        idx--;
                    }
                    size--;
                    break;
                case 'Z':
                    int restoreIdx = stack.pop();
                    if (restoreIdx <= idx) {
                        idx++;
                    }
                    size++;
                    break;
            }
        }
 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append('O');
        }
 
        while (!stack.isEmpty()) {
            sb.insert(stack.pop().intValue(), 'X');
        }
 
        return sb.toString();
    }
 
    private int getDistance(String c) {
        return Integer.parseInt(c.substring(2));
    }
}
