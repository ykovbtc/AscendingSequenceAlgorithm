package algorithm.treebased;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Tree {

    private Node top;
    private List<Node> limbs;
    private Queue<ArrayList<Node>> listPool;

    public Tree(Node top) {
        this.top = top;
        this.limbs = new ArrayList<>();
        this.limbs.addAll(top.childs);
    }

    public List<Node> getLimbs() {
        return limbs;
    }

    public Node getTop() {
        return top;
    }

    public boolean appendElement(Integer value) {
        if (value < top.value) {
            return false;
        } else {
            if (limbs.isEmpty()) {
                limbs.add(new Node(top, value));
            } else {
                    List<Node> newLimbs = new ArrayList<>();
                    for (Node limb : limbs) {
                        newLimbs.add(limb);
                        Node brunch = findAppropriateBrunch(limb, value);
                        if (!isAnyNodeChildContainsValue(brunch, value)) {
                            Node newLimb = new Node(brunch, value);
                            newLimbs.add(newLimb);
                        }
                    }
                    limbs = newLimbs;
                }
            }

        return true;
    }

    public boolean isAnyNodeChildContainsValue(Node node, Integer value) {
        if(node.childs != null && !node.childs.isEmpty()) {
            for (Node child : node.childs) {
                if(child.value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean increaseLimbs(Integer value) {
        Boolean isAtLeastOneAdded = false;
        for (int index = 0; index < limbs.size(); index++) {
            Node limb = limbs.get(index);
            if (limb.value <= value) {
                limbs.set(index, new Node(limb, value));
                isAtLeastOneAdded = true;
            }
        }
        return isAtLeastOneAdded;
    }

    public static Node findAppropriateBrunch(Node limb, Integer value) {
        Node currentBrunch = limb;
        while(currentBrunch.value > value) {
            currentBrunch = currentBrunch.parent;
        }
        return currentBrunch;
    }

}
