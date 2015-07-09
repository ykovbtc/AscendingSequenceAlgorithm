import algorithm.AscendingSequenceFilter;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> sequence1 = Arrays.asList(1, 2, 5, 10);
        List<Integer> sequence2 = Arrays.asList(10, 1, 3, 2, 6, 8);
        List<Integer> sequence3 = Arrays.asList(1, 4, 5, 3, 4, 7, 12, 8);

        AscendingSequenceFilter simpleAlgorithm = new SimpleAlgorithm();

        List<Integer> filteredSequence1 = simpleAlgorithm.filterSequence(sequence1);
        List<Integer> filteredSequence2 = simpleAlgorithm.filterSequence(sequence2);
        List<Integer> filteredSequence3 = simpleAlgorithm.filterSequence(sequence3);

        System.out.println("\n--------------");
        printSequence(filteredSequence1);
        System.out.println("\n--------------");
        printSequence(filteredSequence2);
        System.out.println("\n--------------");
        printSequence(filteredSequence3);
        System.out.println("\n--------------");
    }

    private static void printSequence(List<Integer> filteredSequence) {
        filteredSequence.forEach(integer -> System.out.print(integer + " "));
    }
}
