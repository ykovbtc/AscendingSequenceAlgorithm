import java.util.List;

public class SequenceContainer {

    private List<Integer> initialSequence;
    private List<Integer> expectedSequence;

    public SequenceContainer(List<Integer> initialSequence, List<Integer> expectedSequence) {
        this.initialSequence = initialSequence;
        this.expectedSequence = expectedSequence;
    }

    public List<Integer> getInitialSequence() {
        return initialSequence;
    }

    public void setInitialSequence(List<Integer> initialSequence) {
        this.initialSequence = initialSequence;
    }

    public List<Integer> getExpectedSequence() {
        return expectedSequence;
    }

    public void setExpectedSequence(List<Integer> expectedSequence) {
        this.expectedSequence = expectedSequence;
    }
}
