import java.util.HashSet;
import java.util.Set;

class Solution {
    boolean[] visit;
    Set<Integer> set = new HashSet<>();
    int inputSize;

    public int solution(String numbers) {
        inputSize = numbers.length();
        visit = new boolean[inputSize];

        char[] charArray = numbers.toCharArray();
        for (int i = 1; i <= inputSize; i++) {
            permutation(charArray, new StringBuilder(), i);
        }

        return set.size();
    }

    void permutation(char[] charArray, StringBuilder sb, int size) {
        if (sb.length() == size) {
            int x = Integer.parseInt(sb.toString());
            if (!set.contains(x) && isPrime(x)) {
                set.add(x);
            }
        }

        for (int i = 0; i < inputSize ; i++) {
            if (visit[i]) {
                continue;
            }

            sb.append(charArray[i]);
            visit[i] = true;
            permutation(charArray, sb, size);
            sb.deleteCharAt(sb.length() - 1);
            visit[i] = false;
        }
    }

    private boolean isPrime(int num) {
        if (num == 0 || num == 1) {
            return false;
        }

        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}