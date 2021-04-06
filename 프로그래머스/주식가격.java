import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int size = prices.length;
        int[] answer = new int[size];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size; i++) {
            while (!stack.empty() && prices[stack.peek()] > prices[i]) {
                answer[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }

        while (!stack.empty()) {
            answer[stack.peek()] = size - stack.pop() - 1;
        }
        return answer;
    }
}