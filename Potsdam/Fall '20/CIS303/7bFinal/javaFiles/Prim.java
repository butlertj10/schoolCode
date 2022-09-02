/**
 * Prim uses Prims alogrithm to create a MST 
 *
 * Prim implements a method getMST(Graph g) to create a minimum spanning
 * tree using Prims algorithm. The fucntion is called in MST.java with an 
 * input text file to create the MST. The results will give you the total weight
 * along with a .pmst file, which is the MST.
 *
 * @author Trevor Butler
 * @email butlertj203@potsdam.edu
 * @course CIS 303 Algorithm Analysis and Design
 * @assignment 7b
 * @due 12/14/2020
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Prim {

	/**
	 * getMST uses a paramater of Graph g to get a MST. By following Prims algorithm
	 * we check weights of each path to determine the next path. By comparing weight
	 * we can determine which path to take next while making sure there a full loop
	 * does not occur.
	 * 
	 * @param G
	 * @return set
	 * @throws IOException
	 */
	public static Graph getMST(Graph G) throws IOException {
		G.getVertex(0).visited = true;
		Set<Vertex> vertices = new TreeSet<Vertex>();
		vertices.add(G.getVertex(0));
		Set<Edge> edgesTSet = new TreeSet<Edge>();

		while (vertices.size() < G.vertices.size()) {
			ArrayList<Edge> outsideEdge = new ArrayList<Edge>();

			// for each vertex in vertices create and arrayList
			for (Vertex vertex : vertices) {
				ArrayList<Edge> array = G.edges(vertex);
				for (int i = 0; i < array.size(); i++) {
					if (!array.get(i).dest.visited)
						outsideEdge.add(array.get(i));
				}
			}

			// Creates a temporary array of the outside edges
			Edge[] temp = new Edge[outsideEdge.size()];
			outsideEdge.toArray(temp);

			// Creates a MinHeap using the temporary array
			MinHeap<Edge> heap = new MinHeap(temp, temp.length, temp.length);
			Edge edge = heap.removeMin();
			Vertex dest = edge.dest;
			dest.visited = true;
			vertices.add(dest);
			edgesTSet.add(edge);
		}
		ArrayList<Vertex> Vertex = new ArrayList<Vertex>();
		ArrayList<Edge> Edge = new ArrayList<Edge>();

		// for each vertex in vertices add vertex to the arrayList
		for (Vertex vertex : vertices) {
			Vertex.add(vertex);
		}

		// for each e in edge add edge to the arrayList
		for (Edge e : edgesTSet) {
			Edge.add(e);
		}
		Graph set = new Graph(Vertex, Edge);
		return set;
	}
}