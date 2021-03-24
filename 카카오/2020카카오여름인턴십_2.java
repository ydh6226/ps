import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public long solution(String expression) {
        long answer = 0;
        List<Long> numbers = Arrays.stream(expression.replaceAll("[-+*]", " ").split(" "))
                .map(Long::parseLong).collect(Collectors.toList());
        List<String> operators = Arrays.asList(expression.replaceAll("[^-+*]{1,3}", " ").trim().split(" "));

        List<List<String>> operations = new ArrayList<>(){{
            add(Arrays.asList("*", "+", "-"));
            add(Arrays.asList("+", "-", "*"));
            add(Arrays.asList("+", "*", "-"));
            add(Arrays.asList("-", "+", "*"));
            add(Arrays.asList("-", "*", "+"));
            add(Arrays.asList("*", "-", "+"));
        }};

        for (List<String> operation : operations) {
            List<Long> numberTmp = new ArrayList<>(numbers);
            List<String> opTmp = new ArrayList<>(operators);

            for (String op : operation) {
                for (int i = 0; i < opTmp.size(); i++) {
                    String s = opTmp.get(i);
                    if (!s.equals(op)) {
                        continue;
                    }

                    Long a = numberTmp.get(i);
                    Long b = numberTmp.get(i + 1);
                    long result;

                    if (op.equals("+")){
                        result = a + b;
                    } else if (op.equals("-")) {
                        result = a - b;
                    } else {
                        result = a * b;
                    }

                    numberTmp.set(i, result);
                    numberTmp.remove(i + 1);
                    opTmp.remove(i--);
                }
            }
            answer = Math.max(answer, Math.abs(numberTmp.get(0)));
        }
        return answer;
    }
}