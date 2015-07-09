package algorithm.longestpath;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SequenceElement {
    private Integer value;
    private Integer longestSequenceSize;
    private SequenceElement previousElement;

    public SequenceElement(Integer value) {
        this.value = value;
    }

    private SequenceElement() {
    }

    public static SequenceElement createDefaultElement() {
        SequenceElement element = new SequenceElement();
        element.setLongestSequenceSize(0);
        return element;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getLongestSequenceSize() {
        return longestSequenceSize;
    }

    public void setLongestSequenceSize(Integer longestSequenceSize) {
        this.longestSequenceSize = longestSequenceSize;
    }

    public SequenceElement getPreviousElement() {
        return previousElement;
    }

    public void setPreviousElement(SequenceElement previousElement) {
        this.previousElement = previousElement;
    }

    public List<Integer> getIntegerSequent() {
        List<Integer> integerList = new LinkedList<>();
        integerList = getPreviousInteger(integerList, this);
        Collections.reverse(integerList);
        return integerList;
    }

    private List<Integer> getPreviousInteger(List<Integer> integerList, SequenceElement element) {
        if (element != null && element.getValue() != null) {
            integerList.add(element.getValue());
            getPreviousInteger(integerList, element.getPreviousElement());
        }
        return integerList;
    }


    @Override
    public String toString() {
        return "SequenceElement{" +
                "value=" + value +
                ", longestSequenceSize=" + longestSequenceSize +
                ", previousElement=" + previousElement +
                '}';
    }
}
