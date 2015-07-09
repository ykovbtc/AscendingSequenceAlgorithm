package algorithm.treebased;

public class Node {
    public Node parent;
    public Integer position;
    public Integer value;

    public Node(Node parent, Integer value) {
        this.parent = parent;
        this.value = value;
        this.position = parent == null
                ? 0
                : parent.position + 1;
    }
}
