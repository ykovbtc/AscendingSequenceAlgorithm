package algorithm.longestpath;

import algorithm.AscendingSequenceFilter;

import java.util.List;

public class LongestPathAlgorithm implements AscendingSequenceFilter {

    @Override
    public List<Integer> filterSequence(List<Integer> sequence) {
        Sequence elementSequence = new Sequence(sequence);
        return elementSequence.getLastSequenceElement().getIntegerSequent();
    }
}
