package baconNumber;

import java.util.ArrayList;

/** Sparse graph implementation of Graph interface.
    @param <V> the type of vertex
    @param <E> the type of edge
*/

public class SparseGraph<V, E> implements Graph<V, E> {

    private class Vert implements Vertex<V> {
        Object label;
        ArrayList<Edge<E>> outgoing;
        ArrayList<Edge<E>> incoming;
        V data;
        Graph<V, E> color;

        Vert(V v, Graph<V, E> newColor) {
            this.data = v;
            this.color = newColor;
            this.outgoing = new ArrayList<Edge<E>>();
            this.incoming = new ArrayList<Edge<E>>();
        }

        public V get() {
            return this.data;
        }
        public void put(V v) {
            this.data = v;
        }
    }

    private class AnEdge implements Edge<E> {
        Object label;
        Vertex<V> from;
        Vertex<V> to;
        E data;
        Graph<V, E> color;

        AnEdge(Vertex<V> newFrom, Vertex<V> newTo, E e, Graph<V, E> newColor) {
            this.from = newFrom;
            this.to = newTo;
            this.data = e;
            this.color = newColor;
        }

        public E get() {
            return this.data;
        }
        public void put(E e) {
            this.data = e;
        }
    }

    ArrayList<Vertex<V>> allVertices = new ArrayList<Vertex<V>>();
    ArrayList<Edge<E>> allEdges = new ArrayList<Edge<E>>();

    @Override
    public Vertex<V> insert(V v) {
        Vertex<V> ver = new Vert(v, this);
        this.allVertices.add(ver);
        return ver;
    }

    @Override
    public Edge<E> insert(Vertex<V> from, Vertex<V> to, E e)
        throws IllegalArgumentException {
        Vert vertFrom = this.convert(from);
        Vert vertTo = this.convert(to);

        if (from == to) {
            String error = "A vertex can't have an edge to itself";
            throw new IllegalArgumentException(error);
        }

        for (Edge<E> edge : this.convert(from).outgoing) {
            if (to == this.convert(edge).to) {
                throw new IllegalArgumentException("Edge already exists");
            }
        }

        Edge<E> newEdge = new AnEdge(from, to, e, this);

        vertFrom.outgoing.add(newEdge);
        vertTo.incoming.add(newEdge);
        this.allEdges.add(newEdge);

        return newEdge;
    }

    /** Converters for vertices and edges. */
    private Vert convert(Vertex<V> v) {
        SparseGraph<V, E>.Vert vert;
        if (v == null /*|| !(v instanceof SparseGraph<?, ?>.Vert)*/) {
            throw new IllegalArgumentException("Vertex is not valid");
        }
        vert = (SparseGraph<V, E>.Vert) v;
        if (vert.color != this) {
            throw new IllegalArgumentException("Vertex is not valid");
        }
        return vert;
    }

    private AnEdge convert(Edge<E> e) {
        SparseGraph<V, E>.AnEdge edge;
        if (e == null || !(e instanceof SparseGraph<?, ?>.AnEdge)) {
            throw new IllegalArgumentException("Edge is not valid");
        }
        edge = (AnEdge) e;
        if (edge.color != this) {
            throw new IllegalArgumentException("Edge is not valid");
        }
        return edge;
    }

    @Override
    public V remove(Vertex<V> v)
        throws IllegalArgumentException {
        Vert vert = this.convert(v);

        if (!vert.outgoing.isEmpty() || !vert.incoming.isEmpty()) {
            String error = "Vertex can't be removed since it";
            error += " has edges incident to it";
            throw new IllegalArgumentException(error);
        }
        if (!this.allVertices.contains(v)) {
            throw new IllegalArgumentException("Vertex does not exist");
        }
        this.allVertices.remove(v);
        return v.get();
    }

    @Override
    public E remove(Edge<E> e)
        throws IllegalArgumentException {

        if (!this.allEdges.contains(e)) {
            throw new IllegalArgumentException("Edge does not exist");
        }
        AnEdge edge = this.convert(e);
        Vert temp = this.convert(edge.from);
        temp.outgoing.remove(e);
        temp = this.convert(edge.to);
        temp.incoming.remove(e);
        this.allEdges.remove(e);
        return e.get();
    }

    @Override
    public Iterable<Vertex<V>> vertices() {
        // Make a copy of the arraylist so that
        // Iterator remove function does not affect graph
        ArrayList<Vertex<V>> copy = new ArrayList<Vertex<V>>(this.allVertices);
        return copy;
    }

    @Override
    public Iterable<Edge<E>> edges() {
        // Make a copy of the arraylist so that
        // Iterator remove function does not affect graph
        ArrayList<Edge<E>> copy = new ArrayList<Edge<E>>(this.allEdges);
        return copy;
    }

    @Override
    public Iterable<Edge<E>> outgoing(Vertex<V> v)
        throws IllegalArgumentException {
        Vert vert = this.convert(v);
        return vert.outgoing;
    }

    @Override
    public Iterable<Edge<E>> incoming(Vertex<V> v)
        throws IllegalArgumentException {
        Vert vert = this.convert(v);
        return vert.incoming;
    }

    @Override
    public Vertex<V> from(Edge<E> e)
        throws IllegalArgumentException {
        AnEdge edge = this.convert(e);
        return edge.from;
    }

    @Override
    public Vertex<V> to(Edge<E> e)
        throws IllegalArgumentException {
        AnEdge edge = this.convert(e);
        return edge.to;
    }

    @Override
    public void label(Vertex<V> v, Object l)
        throws IllegalArgumentException {
        Vert vert = this.convert(v);
        vert.label = l;
    }

    @Override
    public void label(Edge<E> e, Object l)
        throws IllegalArgumentException {
        AnEdge edge = this.convert(e);
        edge.label = l;
    }

    @Override
    public Object label(Vertex<V> v)
        throws IllegalArgumentException {
        Vert vert = this.convert(v);
        return vert.label;
    }

    @Override
    public Object label(Edge<E> e)
        throws IllegalArgumentException {
        AnEdge edge = this.convert(e);
        return edge.label;
    }

    @Override
    public void clearLabels() {
        for (Edge<E> e : this.allEdges) {
            AnEdge edge = this.convert(e);
            edge.label = null;
        }
        for (Vertex<V> v : this.allVertices) {
            Vert vert = this.convert(v);
            vert.label = null;
        }
    }

    /** Return a string representation of the graph.
        Suitable for use with GraphViz.
        @return graph a string that represents the graph
    */

    public String toString() {
        String graph = "digraph {\n";
        for (Vertex<V> v : this.allVertices) {
            Vert vert = this.convert(v);
            String label = (String) vert.label;
            graph += " \"" + vert.data + "\";\n";
        }

        for (Edge<E> e : this.allEdges) {
            AnEdge edge = this.convert(e);
            Vert vertFrom = this.convert(edge.from);
            Vert vertTo = this.convert(edge.to);
            graph += " \"" + vertFrom.data + "\" -> \"" + vertTo.data + "\" ";
            graph += "[label=\"" + edge.data + "\"];\n";
        }
        graph += "}";
        return graph;
    }
}
