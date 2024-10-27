package TreeApi.TreeApi.Service;

import TreeApi.TreeApi.Entity.Node;
import TreeApi.TreeApi.Repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class NodeService implements NodeServiceInterface {

    @Autowired
    private NodeRepository nodeRepository;

    @Override
    public Node createNode(Node request) {
        Node response;
        try {
            response = nodeRepository.save(request);
            return response;
        } catch (NullPointerException e) {
            System.out.println("ERROR FOUND ON CREATE MOMENT");
            return null;
        }
    }

    @Override
    public Optional<Node> getById(Long id) {
        Optional<Node> response = nodeRepository.findById(id);
        return response;
    }

    @Override
    public void addChild(Node child) {

    }

    @Override
    public int getDepth() {
        return 0;
    }

    @Override
    public Node searchByRoot(Node current, String rootName) {
        return null;
    }

    @Override
    public Node searchByParentAtDepth(Node current, int depth) {
        return null;
    }

    @Override
    public List<Node> getAll() {
        return nodeRepository.findAll();
    }
}
