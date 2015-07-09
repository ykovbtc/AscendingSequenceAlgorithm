package algorithm.treebased;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private Node top;
    private ArrayList<Node> activeLimbs;
    private ArrayList<Node> passiveLimbs;
    private ArrayListPool<Node> listPool;
    private Integer activeLimbValue;

    public Tree(Node top, ArrayListPool<Node> listPool) {
        this.top = top;
        this.listPool = listPool;
        this.activeLimbs = this.listPool.getList();
        this.passiveLimbs = this.listPool.getList();
        this.activeLimbs.add(top);
        this.activeLimbValue = top.value;
    }

    public List<Node> getActiveLimbs() {
        return activeLimbs;
    }

    public Node getTop() {
        return top;
    }

    public boolean appendElement(Integer value) {
        if (value > top.value) {
            System.out.print(activeLimbs.size() + ",  ");
            return false;
        } else {
                ArrayList<Node> newLimbs = listPool.getList();
                Node furthermostLimb = activeLimbs.get(0);
                for (int i = 1; i < activeLimbs.size(); i++) {
                    Node limb = activeLimbs.get(i);
                    Node brunch = findAppropriateBrunch(limb, value);
                    if(brunch.position > furthermostLimb.position) {
                        furthermostLimb = brunch;
                    }
                    if (brunch != limb) {
                        newLimbs.add(limb);
                    }
                }

                Node newLimb = new Node(furthermostLimb, value);
                newLimbs.add(newLimb);
                listPool.utilizeList(activeLimbs);
                activeLimbs = newLimbs;

        }
        System.out.print(activeLimbs.size() + ",  ");
        return true;
    }

    public static Node findAppropriateBrunch(Node limb, Integer value) {
        Node currentBrunch = limb;
        while (currentBrunch.value < value) {
            currentBrunch = currentBrunch.parent;
        }
        return currentBrunch;
    }

}
