package in.samratc.main.graphs;

import java.util.*;

public class CloneGraph {
}


 // Definition for undirected graph.
class UndirectedGraphNode {
  int label;
  List<UndirectedGraphNode> neighbors;
  UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};
class CloneGraphSol {
    private Map<Integer, UndirectedGraphNode> nodeMap = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode root) {
        if(root == null)
            return root;
        UndirectedGraphNode newRoot = new UndirectedGraphNode(root.label);
        nodeMap.put(root.label, newRoot);
        for(UndirectedGraphNode neighbor : root.neighbors){
            UndirectedGraphNode newNeighbor = nodeMap.containsKey(neighbor.label) ? nodeMap.get(neighbor.label) : cloneGraph(neighbor);
            newRoot.neighbors.add(newNeighbor);
        }
        return newRoot;
    }
}

