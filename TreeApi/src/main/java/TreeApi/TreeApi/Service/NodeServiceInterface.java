package TreeApi.TreeApi.Service;

import TreeApi.TreeApi.Entity.Node;

import java.util.List;
import java.util.Optional;

public interface NodeServiceInterface {
    Node createNode(Node request);
    Optional<Node> getById(Long id);
    void addChild(Node child);
    int getDepth();
    Node searchByRoot(Node current, String rootName);
    Node searchByParentAtDepth(Node current, int depth);
    List<Node> getAll();
}
