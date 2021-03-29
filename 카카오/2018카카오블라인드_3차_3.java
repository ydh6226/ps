import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<File> list = new ArrayList<>();

        for (String file : files) {
            list.add(createFile(file));
        }
        Collections.sort(list);

        int idx = 0;
        for (File file : list) {
            answer[idx++] = file.getFullName();
        }
        return answer;
    }

    private File createFile(String file) {
        int start = 0, end = file.length();
        for (int i = 0; i < file.length() ; i++) {
            if (Character.isDigit(file.charAt(i))) {
                start = i;
                break;
            }
        }

        for (int i = start; i < file.length(); i++) {
            if (!Character.isDigit(file.charAt(i))) {
                end = i;
                break;
            }
        }

        String head = file.substring(0, start);
        String number = file.substring(start, end);
        String tail = file.substring(end);

        return new File(head, number, tail);
    }

    static class File implements Comparable<File> {
        String head;
        String number;
        String tail;

        public File(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        @Override
        public int compareTo(File o) {
            if (this.head.toLowerCase().equals(o.head.toLowerCase())) {
                return Integer.compare(Integer.parseInt(this.number), Integer.parseInt(o.number));
            }
            return this.head.toLowerCase().compareTo(o.head.toLowerCase());
        }

        public String getFullName() {
            return head + number + tail;
        }
    }
}