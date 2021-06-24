import java.io.*;
import java.util.*;

public class Main {
    private static int k;
    private static Set<Integer> plugIn = new HashSet<>();
    private static Map<Integer, Queue<Integer>> remainItems = new HashMap<>();
    private static int[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        k = Integer.parseInt(inputs[1]);

        plugIn = new HashSet<>();
        sequence = new int[k];

        String[] itemInput = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            int item = Integer.parseInt(itemInput[i]);
            Queue<Integer> remainSequence = remainItems.getOrDefault(item, new LinkedList<>());
            remainSequence.add(i);
            remainItems.put(item, remainSequence);
            sequence[i] = item;
        }

        int result = 0;
        for (int i = 0; i < k; i++) {
            if (plugIn.size() < n || plugIn.contains(sequence[i])) {
                plugIn.add(sequence[i]);
                remainItems.get(sequence[i]).poll();
                continue;
            }

            int item = getItemToUnPlug();

            plugIn.remove(item);
            plugIn.add(sequence[i]);
            remainItems.get(sequence[i]).poll();
            result++;
        }
        System.out.println(result);
    }

    private static int getItemToUnPlug() {
        int max = Integer.MIN_VALUE;
        int resultItem = -1;

        for (Integer item : plugIn) {
            Queue<Integer> remainSequence = remainItems.get(item);
            if (remainSequence.size() == 0) {
                return item;
            }

            if (remainSequence.peek() > max) {
                max = remainSequence.peek();
                resultItem = item;
            }
        }
        return resultItem;
    }
}
