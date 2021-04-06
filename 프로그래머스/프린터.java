import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int solution(int[] priorities, int location) {
        int size = priorities.length;

        Stack<Integer> stack = new Stack<>();
        for (int priority : priorities) {
            stack.push(priority);
        }
        Collections.sort(stack);


        int count = 0;
        int printIdx = 0;
        while (!stack.empty()) {
            if (priorities[printIdx] == stack.peek()) {
                stack.pop();
                count++;
                priorities[printIdx] = 0;

                if (printIdx == location) {
                    break;
                }
            }
            printIdx = (printIdx + 1) % size;
        }
        return count;
    }
}