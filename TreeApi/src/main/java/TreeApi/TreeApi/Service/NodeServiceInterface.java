package TreeApi.TreeApi.Service;

import TreeApi.TreeApi.Entity.Node;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface NodeServiceInterface {
    Node createNode(Node request);
    Optional<Node> getById(Long id);
    int getDepth(Node node);
    Node searchByRoot(Node current, String rootName);
    Node searchByParentAtDepth(Node current, int depth);
    Map<String,Integer> analyzeTree(Node tree, List<String> words,int depth);
}
