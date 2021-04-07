import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();

        List<Integer> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(number);
        }

        list.sort(new MyComparator());

        for (Integer i : list) {
            sb.append(i);
        }

        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }

    static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            String s1 = String.valueOf(o1); //330
            String s2 = String.valueOf(o2); //303

            return -(s1 + s2).compareTo(s2 + s1);
        }
    }
}