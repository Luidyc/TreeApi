package TreeApi.TreeApi.Service;

import TreeApi.TreeApi.Entity.Analyzer;
import TreeApi.TreeApi.Entity.Node;
import TreeApi.TreeApi.Repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public int getDepth(Node node) {
        int depth = 0;
        while (node.getParent() != null) {
            depth++;
            node = node.getParent();
        }
        return depth;
    }

    @Override
    public Node searchByRoot(Node current, String rootName) {
        //Compara a string enviada com os titulos
        if(current.getNodeTitle().equalsIgnoreCase(rootName)) {
            return current;
        }
        // Modo recursivo para percorrer filhos
        for (Node child : current.getChildren()) {
            Node response = searchByRoot(child,rootName); {
                if (response!=null) {
                    return response;
                }
            }
        }
        // Não encontrou nada
        return null;
    }

    @Override
    public Node searchByParentAtDepth(Node current, int depth) {
        if (current == null) return null;
        int currentDepth = getDepth(current);
        if (currentDepth == depth) {return current;}
        if (depth < getDepth(current)) {
            return searchByParentAtDepth(current.getParent(), depth);
        }
        return null;
    }

    @Override
    public Map<String, Integer> analyzeTree(Node tree, List<String> words, int depth) {
        Map<String,Integer> wordsCountByLevel = new HashMap<>();

        for (String word : words) {
            Node foundNode = searchByRoot(tree,word);
            if (foundNode != null) {
                Node parentNode = searchByParentAtDepth(foundNode,depth);
                if (parentNode != null) {
                    wordsCountByLevel.put(parentNode.getNodeTitle(),
                        wordsCountByLevel.getOrDefault(parentNode.getNodeTitle(),0)+1);
                }
            }
        }
        return wordsCountByLevel;
    }

    public Analyzer analyze(Analyzer request) {
        List<String> words = request.transformarTextoParaLista(request.getWords());
        Optional<Node> tree = nodeRepository.findById(request.getId());
        if (tree.isPresent()) {
            Map<String, Integer> wordCount = analyzeTree(tree.orElse(null), words, request.getDepth());
                if (wordCount.isEmpty()) {
                    request.setResult("Nada encontrado");
                    return request;
                }
            request.setResult(wordCount.toString());
        }
        return request;
    }
}
