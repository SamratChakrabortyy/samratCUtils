package in.samratc.main;

import java.util.*;

import static java.util.AbstractMap.SimpleEntry;

class Node{
    int val;
    Node left, right;

    public Node(int _val) {
        val = _val;
        left = right = null;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class TiltedViewTree {
    public List<Node> tiltedLeftViewBFS(Node root){
        if(root == null)
            return Collections.emptyList();
        Map<Integer, Node> lastEntry = new HashMap<>();
        Queue<SimpleEntry<Node, Integer>> q = new LinkedList<>();
        q.add(new SimpleEntry<>(root, 0));
        while(!q.isEmpty()){
            SimpleEntry<Node, Integer> curr = q.remove();
            addToQ(curr.getKey().left, curr.getValue(), lastEntry, q);
            addToQ(curr.getKey().right, curr.getValue() + 1, lastEntry, q);
        }
        return new ArrayList<>(lastEntry.values());
    }

    private void addToQ(Node node, int order, Map<Integer, Node> lastEntry, Queue<SimpleEntry<Node, Integer>> q){
        if(node == null)
            return;
        lastEntry.put(order, node);
        q.add(new SimpleEntry<>(node, order));
    }

    public List<Node> tiltedLeftViewDFS(Node root){
        if(root == null)
            return Collections.emptyList();
        Map<Integer, Node> lastEntry = new HashMap<>();
        inOrder(root, 0, lastEntry);
        return new ArrayList<>(lastEntry.values());
    }

    private void inOrder(Node node, int order, Map<Integer, Node> lastEntry){
        if(node == null)
            return;
        lastEntry.put(order, node);
        inOrder(node.left, order, lastEntry);
        inOrder(node.right, order + 1, lastEntry);
    }


    /**
     *                                                                   9
     *                                                                /     \
     *                                                              8         7
     *                                                            /   \         \
     *                                                           1      2         4
     *                                                                 /         /  \
     *                                                                3         5    6
     *
     *                                                     Tilted View -> 1 , 3, 5, 6
     *
     *                                              outPut :
     *                                                          BFS
     *                                                          1 3 5 6
     *                                                          DFS
     *                                                          1 7 5 6
     */

    //Driver
    public static void main(String... args){
        Node root = new Node(9);
        root.left = new Node(8, new Node(1), new Node(2, new Node(3), null));
        root.right = new Node(7, null, new Node(4, new Node(5), new Node(6)));
        TiltedViewTree sol = new TiltedViewTree();
        List<Node> n1 = sol.tiltedLeftViewBFS(root);
        System.out.println("BFS");
        n1.forEach(n -> System.out.print(n.val+ " "));
        List<Node> n2 = sol.tiltedLeftViewDFS(root);
        System.out.println("\nDFS");
        n2.forEach(n -> System.out.print(n.val+ " "));

    }

}
