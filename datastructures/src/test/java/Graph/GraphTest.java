package Graph;

import com.zzz.tutorial.graph.Graph;
import org.junit.Test;

public class GraphTest {

    @Test
    public void dfs_Test_Graph() {
        Graph graph = new Graph();
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);

        graph.addEdge(graph.getNodes().get(0), graph.getNodes().get(1), 0);
        graph.addEdge(graph.getNodes().get(0), graph.getNodes().get(2), 0);
        graph.addEdge(graph.getNodes().get(1), graph.getNodes().get(2), 0);
        graph.addEdge(graph.getNodes().get(2), graph.getNodes().get(0), 0);
        graph.addEdge(graph.getNodes().get(2), graph.getNodes().get(3), 0);
//        graph.addEdge(graph.getNodes().get(3), graph.getNodes().get(3), 0);

        graph.bfs(graph.getNodes().get(2));
    }
}
