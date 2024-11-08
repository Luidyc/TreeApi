package TreeApi.TreeApi.Repository;

import TreeApi.TreeApi.Entity.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeRepository extends JpaRepository<Node, Long> {

}
