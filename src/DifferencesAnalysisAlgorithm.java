import algorithm.AscendingSequenceFilter;

import java.util.ArrayList;
import java.util.List;


public class DifferencesAnalysisAlgorithm implements AscendingSequenceFilter {

    @Override
    public List<Integer> filterSequence(List<Integer> sequence) {
        if(sequence == null || sequence.size() < 2) {
            return sequence;
        }
        List<Integer> differences = calculateDiffs(sequence);
        List<Integer> result = new ArrayList<>();

        return new ArrayList<>();
    }

    private List<Integer> calculateDiffs(List<Integer> sequence) {
        List<Integer> diffs = new ArrayList<>();
        for (int index = 1; index < sequence.size(); index++) {
            diffs.add(sequence.get(index) - sequence.get(index - 1));
        }
        return diffs;
    }
}
