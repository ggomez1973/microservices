import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {
    private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();

    public static class Node {
        private Integer id;
        private LinkedList<Node> adyasent = new LinkedList<Node>();

        private Node(Integer id) {
            this.id = id;
        }
    }

    private Node getNode(Integer id){
        return nodeLookup.get(id);
    }

    private void addEdge(Integer source, Integer destination){
        Node a = getNode(source);
        Node b = getNode(destination);
        a.adyasent.add(b);
    }

    public boolean hasPathDFS(Integer source, Integer destination){
        Node a = getNode(source);
        Node b = getNode(destination);
        HashSet<Integer> visited = new HashSet<Integer>();
        return hasPathDFS(a,b, visited);
    }

    private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited){
        if(visited.contains(source.id)){
            return false;
        }
        visited.add(source.id);
        if(source == destination){
            return true;
        }
        for(Node child : destination.adyasent) {
            if(hasPathDFS(child,destination,visited)){
                return true;
            }
        }
        return false;
    }

    public boolean hasPathBFS(Integer source, Integer destination){
        return hasPathBFS(getNode(source), getNode(destination));
    }

    private boolean hasPathBFS(Node source, Node destination){
        LinkedList<Node> nextToVisit = new LinkedList<Node>();
        HashSet<Integer> visited = new HashSet<Integer>();
        nextToVisit.add(source);
        while(!nextToVisit.isEmpty()){
            Node node = nextToVisit.remove();
            if(node == destination){
                return true;
            }
            if(visited.contains(node.id)){
                continue;
            }
            visited.add(node.id);
            nextToVisit.addAll(node.adyasent);
        }
        return false;
    }
}
