/**
 * Kruskal uses Kruskals alogrithm to create a MST 
 *
 * Kruskal implements a method getMST(Graph g) to create a minimum spanning
 * tree using Kruskals algorithm. The fucntion is called in MST.java with an 
 * input text file to create the MST. The results will give you the total weight
 * along with a .kmst file, which is the MST.
 *
 * @author Trevor Butler
 * @email butlertj203@potsdam.edu
 * @course CIS 303 Algorithm Analysis and Design
 * @assignment 7b
 * @due 12/14/2020
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Kruskal {
    /**
     * getMST works by taking in a .txt file and applying Kruskals algorithm.
     * Sorting all edges in non-decreasing order of weight then picking the smallest
     * edge to compare weights between vertices. This determines which direction
     * would cost the least. while checking for cycle.
     * 
     * @param Graph g
     * @return new Graph(g.vertices, edgesList)
     * @throws IOException
     */
    public static Graph getMST(Graph g) throws IOException {
        Set<Set<Vertex>> hashSet = new HashSet<Set<Vertex>>();

        // Get vertices from graph at i and add them to hashSet
        for (int i = 0; i < g.vertices.size(); i++) {
            Set<Vertex> kSet = new HashSet<Vertex>();
            kSet.add(g.vertices.get(i));
            hashSet.add(kSet);
        }

        // Sort the edges in the heap
        MinHeap<Edge> heap = new MinHeap<Edge>(g.edges.size());
        for (int i = 0; i < g.edges.size(); i++) {
            heap.insert(g.edges.get(i));
        }

        // Create an ArrayList to store edges in edgesList
        ArrayList<Edge> edgesList = new ArrayList<Edge>();

        // While subsets are not merged, create sets and see if span is empty by
        // retainAll checking the second set
        while (hashSet.size() > 1) {
            Edge edge = heap.removeMin();
            Set<Vertex> head = findSet(hashSet, edge.source);
            Set<Vertex> second = findSet(hashSet, edge.dest);
            Set<Vertex> span = new HashSet<Vertex>(head);
            span.retainAll(second);

            // If cross is empty, create a new set, append, adding everthing from second set
            // to it then add/remove from hashSet followed by adding the egde to edgeList
            if (span.isEmpty()) {
                Set<Vertex> append = new HashSet<Vertex>(head);
                append.addAll(second);
                hashSet.remove(head);
                hashSet.remove(second);
                hashSet.add(append);
                edgesList.add(edge);
            }
        }

        // Returns the graph of vertices and edges
        return new Graph(g.vertices, edgesList);
    }

    /**
     * findSet takes in two parameters which finds a set. It iterates for each
     * innerSet in hashSet to check if it contains a vertex. If innerSet conatins a
     * vertex it returns the innerSet. The result is a return of the HashSet set.
     * 
     * @param hashSet
     * @param vertex
     * @return set
     */
    public static Set<Vertex> findSet(Set<Set<Vertex>> hashSet, Vertex vertex) {
        Set<Vertex> set = new HashSet<Vertex>();

        // for each innerSet in hashSet, it checks to see if innerSet contains a vertex
        for (Set<Vertex> innerSet : hashSet) {
            if (innerSet.contains(vertex))
                return innerSet;
        }
        return set;
    }
}