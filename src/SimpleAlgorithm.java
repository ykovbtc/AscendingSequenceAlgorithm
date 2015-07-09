import algorithm.AscendingSequenceFilter;

import java.util.ArrayList;
import java.util.List;

public class SimpleAlgorithm implements AscendingSequenceFilter {

    public List<Integer> filterSequence(List<Integer> sequence) {
        List<Integer> resultList = new ArrayList<>();
        if(sequence.size() == 1) {
            return sequence;
        }
        Integer previousValue = sequence.get(0);
        for (int currentIntex = 1, sequentSize = sequence.size(); currentIntex < sequentSize; currentIntex++) {
            Integer currentValue = sequence.get(currentIntex);
            if(previousValue <= currentValue) {
                resultList.add(previousValue);
                previousValue = currentValue;
            }
        }
        resultList.add(previousValue);
        return resultList;
    }
}
