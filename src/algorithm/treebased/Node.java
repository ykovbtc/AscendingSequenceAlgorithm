package algorithm.treebased;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public Node parent;
    public List<Node> childs;
    public Integer position;
    public Integer value;

    public Node(Node parent, Integer value) {
        this.parent = parent;
        this.value = value;
        childs = new ArrayList<>();
        if(parent == null) {
            this.position = 0;
        } else {
            this.position = parent.position + 1;
            parent.childs.add(this);
        }
    }
}
