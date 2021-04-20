import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String[] operations) {
        List<Integer> numbers = new ArrayList<>();

        for (String operation : operations) {
            String[] split = operation.split(" ");
            String op = split[0];
            int num = Integer.parseInt(split[1]);

            if (op.equals("I")) {
                add(numbers, num);
                continue;
            }

            if (!numbers.isEmpty()) {
                if (num == 1) {
                    numbers.remove(numbers.size() - 1);
                    continue;
                }
                numbers.remove(0);
            }
        }

        int[] answer = new int[2];
        if (numbers.isEmpty()) {
            return answer;
        }

        answer[0] = numbers.get(numbers.size() - 1);
        answer[1] = numbers.get(0);
        return answer;
    }

    private void add(List<Integer> numbers, int num) {
        if (numbers.size() == 0) {
            numbers.add(num);
            return;
        }

        int left = 0;
        int right = numbers.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        numbers.add(right, num);
    }
}