class Solution {
    private String LR;

    public String solution(int[] numbers, String hand) {
        String answer = "";
        if (hand.equals("right")) {
            LR = "R";
        } else {
            LR = "L";
        }

        int left = 10, right = 12;

        for (int number: numbers) {
            if (number == 0) {
                number = 11;
            }

            if (number % 3 == 1) {
                answer += "L";
                left = number;
            } else if (number % 3 == 0) {
                answer += "R";
                right = number;
            } else {
                String check = check(left, right, number);
                answer += check;

                if (check.equals("L")) {
                    left = number;
                } else {
                    right = number;
                }
            }
        }
        return answer;
    }

    /**
     * @param number false: left, true: right
     */
    private String check(int left, int right, int number) {
        int lCount, rCount;

        if (Math.abs(number - left) % 3 != 0) {
            lCount = 1 + Math.abs(left + 1 - number) / 3;
        } else {
            lCount = Math.abs(number - left) / 3;
        }

        if (Math.abs(number - right) % 3 != 0) {
            rCount = 1 + Math.abs(right - 1 - number) / 3;
        } else {
            rCount = Math.abs(number - right) / 3;
        }

        if (lCount < rCount) {
            return "L";
        } else if (lCount > rCount) {
            return "R";
        } else {
            return LR;
        }
    }

}