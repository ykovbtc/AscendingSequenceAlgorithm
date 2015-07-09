import algorithm.AscendingSequenceFilter;
import algorithm.longestpath.LongestPathAlgorithm;
import algorithm.treebased.TreeBasedAlgorithm;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.fail;

public class AscendingSequenceFilterTest {

    private List<SequenceContainer> sequences = Arrays.asList(
            new SequenceContainer(Arrays.asList(-3, 1, 1, 2, 4, 7, 10), Arrays.asList(-3, 1, 1, 2, 4, 7, 10)),

            new SequenceContainer(Arrays.asList(1, 2, 7, 4, 12, 11, 10, 13), Arrays.asList(1, 2, 4, 10, 13)),

            new SequenceContainer(Arrays.asList(3, 10, 4, 5, 8, 6 , 7, 10), Arrays.asList(3, 4, 5, 6, 7, 10)),

            new SequenceContainer(Arrays.asList(1, 1, 1, 1, 1, 1 , 1, 1), Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1)),

            new SequenceContainer(Arrays.asList(3, 4, 5, 0, -1, -2 , -5, -6, 1, 0, 2, 2, 6, 7, 12, 15, 1 ), Arrays.asList(0, 1, 2, 2, 6, 7, 12, 15)),

            new SequenceContainer(Arrays.asList(15, 13, 14, 19, 3, 5, 1, 3, 3, 7, 15, 13, 14, 19, 22, -200, 23), Arrays.asList(3, 3, 3, 7, 13, 14, 19, 22, 23))
    );

    private AscendingSequenceFilter filter;
    private AscendingSequenceFilter filter2;

    @Before
    public void init() {
        //filter = new SimpleAlgorithm();
        //filter = new DifferencesAnalysisAlgorithm();
        filter = new TreeBasedAlgorithm();
        filter2 = new LongestPathAlgorithm();
    }

    @Test
    public void testLogSet() {

        List<Integer> inputList = new ArrayList<>();
        int size = 30;
        for (int i = 0; i < size; i++) {
            Random random = new Random();
            inputList.add(random.nextInt(size));
         //   inputList.add(i+1);
        }
        System.out.println(inputList);
        long startTime = System.currentTimeMillis();
        List<Integer> result = filter.filterSequence(inputList);

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("totalTime: " + totalTime + "; size=" + result.size());
        System.out.println(result);
//rc
        startTime = System.currentTimeMillis();
        result = filter2.filterSequence(inputList);

        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("totalTime: " + totalTime + "; size=" + result.size());
        System.out.println(result);
    }

    @Test
    public void testFilterSequences() throws Exception {
        boolean anyFailed = false;
        for (int index = 0; index < sequences.size(); index++) {
            SequenceContainer sequence = sequences.get(index);
            List<Integer> resultSequence = filter.filterSequence(sequence.getInitialSequence());
            boolean isCurrentFailed = !sequence.getExpectedSequence().equals(resultSequence);
            anyFailed = anyFailed || isCurrentFailed;

            if (isCurrentFailed) {
                System.out.print(String.format("\n--------------------------- Sequence #%s failed ----------------------------\n", index + 1));
                printSequenceInfo(sequence, resultSequence);
                System.out.print("\n---------------------------------------------------------------------------\n\n");
            }
        }
        Thread.sleep(100);
        if(anyFailed) {
            fail();
        }
    }

    private void printSequenceInfo(SequenceContainer sequenceContainer, List<Integer> result) {
        System.out.print("Initial  : ");
        sequenceContainer.getInitialSequence().forEach(element -> System.out.print(element + ", "));
        System.out.print("\nExpected : ");
        sequenceContainer.getExpectedSequence().forEach(element -> System.out.print(element + ", "));
        System.out.print("\nActual   : ");
        result.forEach(element -> System.out.print(element + ", "));
    }
}