import algorithm.AscendingSequenceFilter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ArlamAlg implements AscendingSequenceFilter {
    public List<Integer> filterSequence(List<Integer> initialList) {
        Map<Integer, Set<Integer>> relations = new HashMap<>();
        for (int index = 0; index < initialList.size(); index++) {
            addRelations(relations, initialList, index);
            relations.put(index, new HashSet<>());
        }
        TreeSet<Integer> theLongestChain = getLongerChain(relations, relations.keySet());
        List<Integer> result = theLongestChain.stream().map(initialList::get).collect(Collectors.toList());
        return result;
    }

    private TreeSet<Integer> getLongerChain(Map<Integer, Set<Integer>> relations, Set<Integer> possibleNextElementIds) {
        final TreeSet<Integer> result = new TreeSet<>();
        if (possibleNextElementIds.isEmpty()) {
            return result;
        }
        int max = -1;
        Integer nextValueIndex = null;
        for (Integer index : possibleNextElementIds) {
            final int size = relations.get(index).size();
            if (max < size) {
                max = size;
                nextValueIndex = index;
            }
        }
        result.add(nextValueIndex);
        result.addAll(getLongerChain(relations, relations.get(nextValueIndex)));
        return result;
    }

    private void addRelations(Map<Integer, Set<Integer>> relations, List<Integer> list, Integer elementNumber) {
        final Integer currentElement = list.get(elementNumber);
        relations.keySet()
                .stream()
                .filter(index -> list.get(index) <= currentElement)
                .forEach(index -> relations.get(index).add(elementNumber)
                );
    }

}