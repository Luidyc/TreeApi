package TreeApi.TreeApi.Controller;


import TreeApi.TreeApi.Entity.Node;
import TreeApi.TreeApi.Service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Tree")
public class NodeController {

    @Autowired
    private NodeService service;

    @PostMapping
    private ResponseEntity<Node> create(@RequestBody @Validated Node request){
        Node response = service.createNode(request);
        if(response.getId()!=null) return new ResponseEntity<>(response, HttpStatus.CREATED);
        else {return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}
    }

    @GetMapping("/")
    public ResponseEntity<List<Node>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping
    private ResponseEntity<Node> getById(@RequestParam("id") Long id){
        Optional<Node> response = service.getById(id);
        return response.map(Node -> ResponseEntity.ok(response.get()))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
