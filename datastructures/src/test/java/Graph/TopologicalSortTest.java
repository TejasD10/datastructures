package Graph;

import com.zzz.tutorial.graph.Graph;
import org.junit.Test;

public class TopologicalSortTest {

    @Test
    public void topologicalSorting_test() {
        Graph graph = new Graph();
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);

        // Add edges
        graph.addEdge(graph.getNodes().get(5), graph.getNodes().get(2), 0);
        graph.addEdge(graph.getNodes().get(5), graph.getNodes().get(0), 0);
        graph.addEdge(graph.getNodes().get(4), graph.getNodes().get(0), 0);
        graph.addEdge(graph.getNodes().get(4), graph.getNodes().get(1), 0);
        graph.addEdge(graph.getNodes().get(2), graph.getNodes().get(3), 0);
        graph.addEdge(graph.getNodes().get(3), graph.getNodes().get(1), 0);

        graph.topologicalSort();
    }
}
