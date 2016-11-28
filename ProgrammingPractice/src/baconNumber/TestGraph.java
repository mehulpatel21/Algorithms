package baconNumber;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TestGraph {

    private interface Fixture {
        Graph<String, String> init();
    }

    @DataPoint
    public static final Fixture graph = new Fixture() {
        public Graph<String, String> init() {
            return new SparseGraph<>();
        }
    };
    
    @Theory
    public void positionGetandPutMethodWorks(Fixture fix) {
        // This also tests that the method works and returns
        // iterable<Vertex<E>>
        Graph<String, String> gr = fix.init();
        Position<String> p = gr.insert("Hi!");
        assertEquals(p.get(), "Hi!");
        p.put("sup");
        assertEquals(p.get(), "sup");
    }
    @Theory
    public void positionGetandPutWorksForEdge(Fixture fix) {
        // This also tests that the method works and returns
        // iterable<Vertex<E>>
        Graph<String, String> gr = fix.init();
        Vertex<String> v = gr.insert("Hi!");
        Vertex<String> vnew = gr.insert("Other");
        Position<String> p = gr.insert(v, vnew, "Hi!");
        assertEquals(p.get(), "Hi!");
        p.put("Hello");
        assertEquals(p.get(), "Hello");
    }
    @Theory
    public void emptyGraphHasEmptyIteratorVertices(Fixture fix) {
        // This also tests that the method works and returns
        // iterable<Vertex<E>>
        Graph<String, String> gr = fix.init();
        int size = 0;
        for (Vertex<String> v : gr.vertices()) {
            size += 1;
        }
        assertEquals(size, 0);
    }
    @Theory
    public void emptyGraphHasEmptyIteratorEdges(Fixture fix) {
        // This also tests that the method works and returns
        // iterable<Edge<E>>
        Graph<String, String> gr = fix.init();
        int size = 0;
        for (Edge<String> e : gr.edges()) {
            size += 1;
        }
        assertEquals(size, 0);
    }
    
    @Theory
    public void insertVertexWorks(Fixture fix) {
        Graph<String, String> gr = fix.init();
        Vertex<String> v = gr.insert("This is a vertex");
        boolean exists = false;
        for (Vertex<String> vert : gr.vertices()) {
            if (vert == v) {
                exists = true;
            }
        }
        assertTrue(exists);
    }
    
    @Theory
    public void insertEdgeWorks(Fixture fix) {
        Graph<String, String> gr = fix.init();
        Vertex<String> v = gr.insert("Hi!");
        Vertex<String> vnew = gr.insert("Other");
        Edge<String> e = gr.insert(v, vnew, "Edge");
        boolean exists = false;
        for (Edge<String> edge : gr.edges()) {
            if (edge == e) {
                exists = true;
            }
        }
        assertTrue(exists);
    }
    

    @Theory @Test(expected=IllegalArgumentException.class)
    public void badVerticesThrowsIllegalException(Fixture fix) {
        Graph<String, String> gr = fix.init();
        gr.insert(null, null, "Edge");
    }

    @Theory @Test(expected=IllegalArgumentException.class)
    public void cantInsertExistingEdge(Fixture fix) {
        Graph<String, String> gr = fix.init();
        Vertex<String> v = gr.insert("Hi!");
        Vertex<String> vnew = gr.insert("Other");
        gr.insert(v, vnew, "Edge");
        gr.insert(v, vnew, "Edge");
    }
    
    @Theory @Test(expected=IllegalArgumentException.class)
    public void cantHaveEdgeWithItself(Fixture fix) {
        Graph<String, String> gr = fix.init();
        Vertex<String> v = gr.insert("Hi!");
        gr.insert(v, v, "Edge");
    }
    @Theory
    public void testRemoveVertexWorks(Fixture fix) {
        Graph<String, String> gr = fix.init();
        Vertex<String> v = gr.insert("This is a vertex");
        assertEquals("This is a vertex", gr.remove(v));
        boolean exists = false;
        for (Vertex<String> vert : gr.vertices()) {
            if (vert == v) {
                exists = true;
            }
        }
        assertFalse(exists);
    }
    @Theory
    public void testRemoveEdgeWorks(Fixture fix) {
        Graph<String, String> gr = fix.init();
        Vertex<String> v1 = gr.insert("This is a vertex");
        Vertex<String> v2 = gr.insert("This is a vertex");
        Edge<String> e = gr.insert(v1, v2, "This is edge");
        assertEquals("This is edge", gr.remove(e));
        
        boolean exists = false;
        for (Edge<String> edge : gr.edges()) {
            if (edge == e) {
                exists = true;
            }
        }
        assertFalse(exists);
    }

    @Theory @Test(expected=IllegalArgumentException.class)
    public void testRemoveVertexThrowsException(Fixture fix) {
        Graph<String, String> gr = fix.init();
        Graph<String, String> gr2 = fix.init();
        Vertex<String> v1 = gr.insert("This is a vertex");
        Vertex<String> v2 = gr.insert("This is a vertex");
        Edge<String> e = gr.insert(v1, v2, "This is edge");

        // Trying to remove v1, which has incident edges,
        // should throw IllegalArgumentException
        gr.remove(v1);
    }
    
    @Theory @Test(expected=IllegalArgumentException.class)
    public void testRemoveEdgeThrowsException(Fixture fix) {
        Graph<String, String> gr = fix.init();
        Graph<String, String> gr2 = fix.init();
        Vertex<String> v1 = gr.insert("This is a vertex");
        Vertex<String> v2 = gr.insert("This is a vertex");
        Edge<String> e = gr.insert(v1, v2, "This is edge");

        // Trying to remove e from gr2 (it belongs in gr)
        // should throw an error.
        gr2.remove(e);
    }
    @Theory
    public void testOutgoingMethodWorks(Fixture fix) {
        Graph<String, String> gr = fix.init();
        Vertex<String> v1 = gr.insert("This is a vertex");
        Vertex<String> v2 = gr.insert("This is a vertex");
        Vertex<String> v3 = gr.insert("This is a vertex");
        Edge<String> e1 = gr.insert(v1, v2, "This is edge");
        Edge<String> e2 = gr.insert(v1, v3, "This is edge");
        
        int exists = 0;
        for (Edge<String> edge : gr.outgoing(v1)) {
            // Check that outgoing contains both e1 and e2
            if (edge == e1) {
                exists += 1;
            }
            if (edge == e2) {
                exists += 1;
            }
        }
        assertEquals(exists, 2);
    }

    @Theory @Test(expected=IllegalArgumentException.class)
    public void outgoingMethodFailsIfInvalidVertex(Fixture fix) {
        Graph<String, String> gr = fix.init();
        gr.outgoing(null);
    }
    @Theory @Test(expected=IllegalArgumentException.class)
    public void outgoingMethodFailIfVertexFromOtherGraph(Fixture fix) {
        Graph<String, String> gr = fix.init();
        Graph<String, String> gr2 = fix.init();
        Vertex<String> v1 = gr.insert("This is a vertex");
        gr2.outgoing(v1);
    }
    @Theory
    public void testIncomingMethodWorks(Fixture fix) {
        Graph<String, String> gr = fix.init();
        Vertex<String> v1 = gr.insert("This is a vertex");
        Vertex<String> v2 = gr.insert("This is a vertex");
        Vertex<String> v3 = gr.insert("This is a vertex");
        Edge<String> e1 = gr.insert(v2, v1, "This is edge");
        Edge<String> e2 = gr.insert(v3, v1, "This is edge");
        
        int exists = 0;
        for (Edge<String> edge : gr.incoming(v1)) {
            // Check that outgoing contains both e1 and e2
            if (edge == e1) {
                exists += 1;
            }
            if (edge == e2) {
                exists += 1;
            }
        }
        assertEquals(exists, 2);
    }

    @Theory @Test(expected=IllegalArgumentException.class)
    public void incomingMethodFailsIfInvalidVertex(Fixture fix) {
        Graph<String, String> gr = fix.init();
        gr.incoming(null);
    }
    @Theory @Test(expected=IllegalArgumentException.class)
    public void incomingMethodFailIfVertexFromOtherGraph(Fixture fix) {
        Graph<String, String> gr = fix.init();
        Graph<String, String> gr2 = fix.init();
        Vertex<String> v1 = gr.insert("This is a vertex");
        gr2.incoming(v1);
    }

    @Theory
    public void testToandFromWork(Fixture fix) {
        Graph<String, String> gr = fix.init();
        Vertex<String> v1 = gr.insert("This is a vertex");
        Vertex<String> v2 = gr.insert("This is a vertex");
        Vertex<String> v3 = gr.insert("This is a vertex");
        Edge<String> e1 = gr.insert(v2, v1, "This is edge");

        assertEquals(v2, gr.from(e1));
        assertEquals(v1, gr.to(e1));
    }
    
    @Theory @Test(expected=IllegalArgumentException.class)
    public void toFailsIfInvalid(Fixture fix) {
        Graph<String, String> gr = fix.init();
        gr.to(null);
    }
    @Theory @Test(expected=IllegalArgumentException.class)
    public void fromFailsIfInvalid(Fixture fix) {
        Graph<String, String> gr = fix.init();
        gr.from(null);
    }
    @Theory @Test(expected=IllegalArgumentException.class)
    public void toFailsIfFromDiffGraph(Fixture fix) {
        Graph<String, String> gr = fix.init();
        Graph<String, String> gr2 = fix.init();
        Vertex<String> v1 = gr.insert("This is a vertex");
        Vertex<String> v2 = gr.insert("This is a vertex");
        Vertex<String> v3 = gr.insert("This is a vertex");
        Edge<String> e1 = gr.insert(v2, v1, "This is edge");
        gr2.to(e1);
    }
    @Theory @Test(expected=IllegalArgumentException.class)
    public void fromFailsIfFromDiffGraph(Fixture fix) {
        Graph<String, String> gr = fix.init();
        Graph<String, String> gr2 = fix.init();
        Vertex<String> v1 = gr.insert("This is a vertex");
        Vertex<String> v2 = gr.insert("This is a vertex");
        Vertex<String> v3 = gr.insert("This is a vertex");
        Edge<String> e1 = gr.insert(v2, v1, "This is edge");
        gr2.from(e1);
    }

    /* Labels! */
    
    @Theory
    public void labelVertexWorks(Fixture fix) {
        Graph<String, String> gr = fix.init();
        Vertex<String> v1 = gr.insert("This is a vertex");
        gr.label(v1, "labelled");
        assertEquals(gr.label(v1), "labelled");
    }
    @Theory
    public void labelEdgeWorks(Fixture fix) {
        Graph<String, String> gr = fix.init();
        Vertex<String> v1 = gr.insert("This is a vertex");
        Vertex<String> v2 = gr.insert("This is a vertex");
        Vertex<String> v3 = gr.insert("This is a vertex");
        Edge<String> e1 = gr.insert(v2, v1, "This is edge");
        gr.label(e1, "labelled");
        assertEquals(gr.label(e1), "labelled");
    }
    @Theory @Test(expected=IllegalArgumentException.class)
    public void labelsThrowAppropriateExceptionNullVertex(Fixture fix) {
        Graph<String, String> gr = fix.init();
        Vertex<String> v = null;
        gr.label(v);
    }
    @Theory @Test(expected=IllegalArgumentException.class)
    public void labelsThrowAppropriateExceptionNullEdge(Fixture fix) {
        Graph<String, String> gr = fix.init();
        Edge<String> e = null;
        gr.label(e);
    }
    @Theory @Test(expected=IllegalArgumentException.class)
    public void labelsThrowAppropriateExceptionVertex(Fixture fix) {
        Graph<String, String> gr = fix.init();
        Graph<String, String> gr2 = fix.init();
        Vertex<String> v1 = gr.insert("This is a vertex");
        gr2.label(v1);
    }
    @Theory @Test(expected=IllegalArgumentException.class)
    public void labelsThrowAppropriateExceptionEdge(Fixture fix) {
        Graph<String, String> gr = fix.init();
        Graph<String, String> gr2 = fix.init();
        Vertex<String> v1 = gr.insert("This is a vertex");
        Vertex<String> v2 = gr.insert("This is a vertex");
        Edge<String> e1 = gr.insert(v2, v1, "This is edge");
        gr2.label(e1);
    }
    @Theory @Test(expected=IllegalArgumentException.class)
    public void labelsThrowAppropriateExceptionVertexLabel(Fixture fix) {
        Graph<String, String> gr = fix.init();
        Graph<String, String> gr2 = fix.init();
        Vertex<String> v1 = gr.insert("This is a vertex");
        gr2.label(v1, "Vert");
    }
    @Theory @Test(expected=IllegalArgumentException.class)
    public void labelsThrowAppropriateExceptionEdgeLabel(Fixture fix) {
        Graph<String, String> gr = fix.init();
        Graph<String, String> gr2 = fix.init();
        Vertex<String> v1 = gr.insert("This is a vertex");
        Vertex<String> v2 = gr.insert("This is a vertex");
        Edge<String> e1 = gr.insert(v2, v1, "This is edge");
        gr2.label(e1, "Edge");
    }
    @Theory @Test(expected=IllegalArgumentException.class)
    public void labelsThrowAppropriateExceptionNullVert2(Fixture fix) {
        Graph<String, String> gr = fix.init();
        Vertex<String> v = null;
        gr.label(v, "Something");
    }
    @Theory @Test(expected=IllegalArgumentException.class)
    public void labelsThrowAppropriateExceptionNullEdge2(Fixture fix) {
        Graph<String, String> gr = fix.init();
        Edge<String> e = null;
        gr.label(e, "Something");
    }

    @Theory
    public void clearLabelsWorks(Fixture fix) {
        Graph<String, String> gr = fix.init();
        Vertex<String> v1 = gr.insert("This is a vertex");
        Vertex<String> v2 = gr.insert("This is a vertex");
        Edge<String> e1 = gr.insert(v2, v1, "This is edge");
        gr.label(e1, "edge");
        gr.label(v1, "vert");
        gr.label(v2, "vert");
        gr.clearLabels();
        assertEquals(gr.label(e1), null);    
        assertEquals(gr.label(v1), null);    
        assertEquals(gr.label(v2), null);    
    }

    @Theory
    public void toStringWorks(Fixture fix) {
        Graph<String, String> gr = fix.init();
        Vertex<String> v1 = gr.insert("v1");
        Vertex<String> v2 = gr.insert("v2");
        Edge<String> e1 = gr.insert(v1, v2, "e1");
        String compare = "digraph {\n \"v1\";\n \"v2\";\n \"v1\" -> \"v2\" [label=\"e1\"];\n}";
        assertEquals(gr.toString(), compare);
    }
}
