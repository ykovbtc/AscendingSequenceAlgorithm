package algorithm.treebased;

import algorithm.AscendingSequenceFilter;

import java.util.LinkedList;
import java.util.List;

public class TreeBasedAlgorithm implements AscendingSequenceFilter {

    @Override
    public List<Integer> filterSequence(List<Integer> sequence) {
        if(sequence == null || sequence.size() < 2) {
            return sequence;
        }

        ArrayListPool<Node> nodeArrayListPool = new ArrayListPool<>(sequence.size() / 100 + 2, sequence.size() / 1000 + 10);

        LinkedList<Tree> trees = new LinkedList<>();
        trees.add(new Tree(new Node(null, sequence.get(sequence.size() - 1)), nodeArrayListPool));

        for (int index = sequence.size() - 2; index >= 0 ; index--) {
            Integer elementValue = sequence.get(index);
            boolean isAdded = appendValueToTrees(trees, elementValue);
            if(!isAdded) {
                Tree tree = new Tree(new Node(null, elementValue), nodeArrayListPool);
                trees.add(tree);
            }
            System.out.print("\nelementIndex : " + index + " trees: " + trees.size() + " limbs: ");
        }

        Node longestNode = findLongestNode(trees);


        List<Integer> output = new LinkedList<>();
        do {
            output.add(longestNode.value);
            longestNode = longestNode.parent;
        } while (longestNode != null);

        return output;
    }

    private Node findLongestNode(LinkedList<Tree> trees) {
        Node longestNode = null;
        for (Tree tree : trees) {
            for (Node node : tree.getActiveLimbs()) {
                if(longestNode == null) {
                    longestNode = node;
                }
                if(node.position > longestNode.position) {
                    longestNode = node;
                }
            }
        }
        return longestNode;
    }

    private boolean appendValueToTrees(LinkedList<Tree> trees, Integer elementValue) {
        boolean isSuccessfullyAdded = false;
        for (Tree tree : trees) {
            isSuccessfullyAdded = tree.appendElement(elementValue) || isSuccessfullyAdded;
        }
        return isSuccessfullyAdded;
    }
}
