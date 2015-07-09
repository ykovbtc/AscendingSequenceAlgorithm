package algorithm.treebased;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TreeTest {

    private ArrayListPool<Node> listPool = new ArrayListPool<>(0, 0);

    @Test
    public void testConstructor() {
        Node parentNode = new Node(null, 5);
        Node childNode = new Node(parentNode, 6);
        Tree tree = new Tree(parentNode, listPool);

        assertEquals(parentNode, tree.getTop());
        assertEquals(childNode, tree.getActiveLimbs().get(0));
    }


    @Test
    public void testAppendElementFail() throws Exception {
        Node top = new Node(null, 5);
        Tree tree = new Tree(top, listPool);
        assertFalse(tree.appendElement(4));
    }

    @Test
    public void testAppendElementIfFirst() throws Exception {
        Integer elementValue = 6;
        Node top = new Node(null, 5);
        Tree tree = new Tree(top, listPool);
        assertTrue(tree.appendElement(elementValue));
        assertEquals(1, tree.getActiveLimbs().size());
        assertEquals(elementValue, tree.getActiveLimbs().get(0).value);
    }

    @Test
    public void testAppendElements() /*-3, 1, 2, 4 */ throws Exception {

        Node top = new Node(null, -3);
        Tree tree = new Tree(top, listPool);

        tree.appendElement(1);
        tree.appendElement(2);
        tree.appendElement(4);

        assertEquals(1, tree.getActiveLimbs().size());
        assertEquals(4, tree.getActiveLimbs().get(0).value.intValue());
        assertEquals(3, tree.getActiveLimbs().get(0).position.intValue());
        assertEquals(top, tree.getActiveLimbs().get(0).parent.parent.parent);
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