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
        LinkedList<Tree> trees = new LinkedList<>();
        trees.add(new Tree(new Node(null, sequence.get(0))));

        for (int index = 1; index < sequence.size(); index++) {
            Integer elementValue = sequence.get(index);
            boolean isAdded = appendValueToTrees(trees, elementValue);
            if(!isAdded) {
                Tree tree = new Tree(new Node(null, elementValue));
                trees.add(tree);
            }
        }

        Node longestNode = findLongestNode(trees);


        List<Integer> output = new LinkedList<>();
        do {
            output.add(longestNode.value);
            longestNode = longestNode.parent;
        } while (longestNode != null);

        return reverse(output);
    }

    private List<Integer> reverse(List<Integer> output) {
        List<Integer> list = new LinkedList<>();
        for (int i = output.size() - 1; i >= 0; i--) {
            list.add(output.get(i));
        }
        return list;
    }

    private Node findLongestNode(LinkedList<Tree> trees) {
        Node longestNode = null;
        for (Tree tree : trees) {
            for (Node node : tree.getLimbs()) {
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
