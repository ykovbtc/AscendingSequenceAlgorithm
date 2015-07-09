package algorithm.treebased;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class NodeTest {

    @Test
    public void constructorWithNullParent() throws Exception {
        Integer value = 5;
        Node node = new Node(null, value);
        assertNull(node.parent);
        assertTrue(node.childs.isEmpty());
        assertEquals(0, node.position.intValue());
        assertEquals(value, node.value);
    }

    @Test
    public void constructorWithParent() throws Exception {
        Node parentNode = new Node(null, 7);
        Integer value = 5;
        Node node = new Node(parentNode, value);
        assertEquals(parentNode, node.parent);
        assertTrue(node.childs.isEmpty());
        assertEquals(1, node.position.intValue());
        assertEquals(value, node.value);

        assertEquals(1, node.parent.childs.size());
        assertEquals(node, node.parent.childs.get(0));
    }
}