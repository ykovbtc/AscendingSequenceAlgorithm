package algorithm.longestpath;

import java.util.LinkedList;
import java.util.List;

public class Sequence {

    private List<SequenceElement> elementList;
    private SequenceElement lastSequenceElement;

    public Sequence(List<Integer> inputIntegerList) {
        elementList = new LinkedList<>();
        lastSequenceElement = SequenceElement.createDefaultElement();
        for (Integer inputElement : inputIntegerList) {
            SequenceElement element = new SequenceElement(inputElement);
            SequenceElement previousElementFromLongestSequent = findPreviousElementFromLongestSeqForElementFromList(element, elementList);
            element.setPreviousElement(previousElementFromLongestSequent);
            Integer sequenceLength = previousElementFromLongestSequent.getLongestSequenceSize() + 1;
            element.setLongestSequenceSize(sequenceLength);
            elementList.add(element);
            if (sequenceLength > lastSequenceElement.getLongestSequenceSize()) {
                lastSequenceElement = element;
            }
        }
    }

    public SequenceElement findPreviousElementFromLongestSeqForElementFromList(SequenceElement element, List<SequenceElement> elements) {
        SequenceElement previousElement = SequenceElement.createDefaultElement();
        for (SequenceElement candidate : elements) {
            if (element.getValue() >= candidate.getValue()) {
                if (candidate.getLongestSequenceSize() > previousElement.getLongestSequenceSize()) {
                    previousElement = candidate;
                }
            }
        }
        return previousElement;
    }

    public SequenceElement getLastSequenceElement() {
        return lastSequenceElement;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Element List: \n");
        for(SequenceElement element: elementList) {
            sb.append(element.toString() + " \n");
        }
        return sb.toString();
    }
}

