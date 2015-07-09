package algorithm.treebased;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TreeTest {

    @Test
    public void testConstructor() {
        Node parentNode = new Node(null, 5);
        Node childNode = new Node(parentNode, 6);
        Tree tree = new Tree(parentNode);

        assertEquals(parentNode, tree.getTop());
        assertEquals(childNode, tree.getLimbs().get(0));
        assertEquals(childNode, parentNode.childs.get(0));
        assertEquals(0, childNode.childs.size());
    }


    @Test
    public void testAppendElementFail() throws Exception {
        Node top = new Node(null, 5);
        Tree tree = new Tree(top);
        assertFalse(tree.appendElement(4));
    }

    @Test
    public void testAppendElementIfFirst() throws Exception {
        Integer elementValue = 6;
        Node top = new Node(null, 5);
        Tree tree = new Tree(top);
        assertTrue(tree.appendElement(elementValue));
        assertEquals(1, tree.getLimbs().size());
        assertEquals(elementValue, tree.getLimbs().get(0).value);
        assertEquals(1, top.childs.size());
        assertEquals(elementValue, top.childs.get(0).value);
    }

    @Test
    public void testAppendElements() /*-3, 1, 2, 4 */ throws Exception {

        Node top = new Node(null, -3);
        Tree tree = new Tree(top);

        tree.appendElement(1);
        tree.appendElement(2);
        tree.appendElement(4);

        assertEquals(1, tree.getLimbs().size());
        assertEquals(4, tree.getLimbs().get(0).value.intValue());
        assertEquals(3, tree.getLimbs().get(0).position.intValue());
        assertEquals(top, tree.getLimbs().get(0).parent.parent.parent);
    }



    @Test
    public void testIsAnyNodeChildContainsValueSuccess() throws Exception {
        Node parent = new Node(null, 0);
        Node child1 = new Node(parent, 1);
        Node child2 = new Node(parent, 3);
        Node child3 = new Node(parent, 5);
        Tree tree = new Tree(parent);
        assertTrue(tree.isAnyNodeChildContainsValue(parent, 3));
    }

    @Test
    public void testIsAnyNodeChildContainsValueFail() throws Exception {
        Node parent = new Node(null, 0);
        Node child1 = new Node(parent, 1);
        Node child2 = new Node(parent, 3);
        Node superChild2_1 = new Node(child2, 5);
        Tree tree = new Tree(parent);
        assertFalse(tree.isAnyNodeChildContainsValue(parent, 5));
    }

    @Test
    public void testIncreaseLimbsSuccess() throws Exception {
        Integer newLimbValue = 9;
        Node parentNode = new Node(null, 5);
        Node childNode1 = new Node(parentNode, 8);
        Node childNode2 = new Node(parentNode, 11);
        Tree tree = new Tree(parentNode);
        Boolean isOneIncreased = tree.increaseLimbs(newLimbValue);

        assertTrue(isOneIncreased);
        assertEquals(2, tree.getLimbs().size());
        assertEquals(newLimbValue, tree.getLimbs().get(0).value);
        assertEquals(childNode2, tree.getLimbs().get(1));
        assertEquals(childNode1, parentNode.childs.get(0));
        assertEquals(childNode2, parentNode.childs.get(1));
        assertEquals(0, childNode2.childs.size());
        assertEquals(1, childNode1.childs.size());
    }

    @Test
    public void testIncreaseLimbsFail() throws Exception {
        Integer newLimbValue = 7;
        Node parentNode = new Node(null, 5);
        Node childNode1 = new Node(parentNode, 8);
        Node childNode2 = new Node(parentNode, 11);
        Tree tree = new Tree(parentNode);
        Boolean isOneIncreased = tree.increaseLimbs(newLimbValue);

        assertFalse(isOneIncreased);
        assertEquals(2, tree.getLimbs().size());
        assertEquals(childNode1, tree.getLimbs().get(0));
        assertEquals(childNode2, tree.getLimbs().get(1));
        assertEquals(childNode1, parentNode.childs.get(0));
        assertEquals(childNode2, parentNode.childs.get(1));
        assertEquals(0, childNode2.childs.size());
        assertEquals(0, childNode1.childs.size());
    }

    @Test
    public void testFindAppropriateBrunch() throws Exception {
        Node parentNode = new Node(null, 1);
        Node child1Node = new Node(parentNode, 2);
        Node child2Node = new Node(child1Node, 5);
        Node child3Node = new Node(child2Node, 7);
        Node child4Node = new Node(child3Node, 9);

        Node appropriateBrunch = Tree.findAppropriateBrunch(child4Node, 3);
        assertEquals(child1Node, appropriateBrunch);
    }
}